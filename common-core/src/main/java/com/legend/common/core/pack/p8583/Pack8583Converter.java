package com.legend.common.core.pack.p8583;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.core.exception.Pack8583ConvException;
import com.legend.common.core.exception.Pack8583LoadException;
import com.legend.common.core.exception.Unpack8583ConvException;
import com.legend.common.utils.DataUtil;
import com.legend.common.utils.DigestUtil;

public class Pack8583Converter {

	private static Logger logger = LoggerFactory.getLogger(Pack8583Converter.class);

	private Map<Integer, Pack8583Dic> dataDicMap = new HashMap<Integer, Pack8583Dic>(); // 8583数据字典
	private Pack8583DicMap pack8583DicMap;

	/*
	 * 使用spring构造函数注入
	 */
	public Pack8583Converter(String dataDicFilePath) throws Pack8583LoadException {
		if (dataDicFilePath == null) {
			throw new Pack8583LoadException("装载8583数据字典配置文件错误[" + dataDicFilePath + "]");
		}
		try {
			JAXBContext jc = JAXBContext.newInstance(Pack8583DicMap.class);
			Unmarshaller ums = jc.createUnmarshaller();
			logger.info("装载8583数据字典配置文件[" + dataDicFilePath + "]");
			this.pack8583DicMap = (Pack8583DicMap) ums.unmarshal(new File(dataDicFilePath));
		} catch (JAXBException e) {
			throw new Pack8583LoadException("装载8583数据字典配置文件错误[" + dataDicFilePath + "]" + e);
		}

		List<Pack8583Dic> pack8583Dics = this.pack8583DicMap.getPack8583Dic();
		for (Pack8583Dic pack8583Dic : pack8583Dics) {
			this.dataDicMap.put(pack8583Dic.getBitSeq().getValue(), pack8583Dic);
		}
		logger.info("装载8583数据字典配置文件成功！！！");
	}

	public byte[] to8583(Map<String, Object> dataMap) throws Pack8583ConvException {
		return to8583(dataMap, this.pack8583DicMap.getBitMapLen(), this.pack8583DicMap.getCharsetName());
	}

	private byte[] to8583(Map<String, Object> dataMap, int bitMapLen, String charsetName) throws Pack8583ConvException {
		StringBuffer mab = new StringBuffer();
		int mapLen = bitMapLen / 8;
		String msgId = (String) dataMap.get("MSGID");
		logger.info("MSGID=[" + msgId + "]");
		if (msgId == null) {
			throw new Pack8583ConvException("MSGID未设置");
		}
		byte[] bitMap = new byte[mapLen + 4];
		System.arraycopy(msgId.getBytes(), 0, bitMap, 0, 4);
		byte[] dataArea = null;
		for (int i = 0; i < mapLen; ++i) {
			bitMap[4 + i] = 0X00;
			for (int j = 0; j < 8; ++j) {
				int bitSeq = i * 8 + j + 1;
				if (bitSeq == 1) { // 处理第一位bit图
					if (bitMapLen == 128) {
						bitMap[4 + i] ^= 0X80 >> j;
					}
					continue;
				}
				Pack8583Dic p8583Dic = dataDicMap.get(bitSeq);
				if (p8583Dic == null) {
					continue;
				}
				String dataCode = p8583Dic.getDataCode();
				if (dataCode == null) {
					throw new Pack8583ConvException("数据字典配置错误");
				}
				String dataType = p8583Dic.getDataType();
				if (dataType == null) {
					throw new Pack8583ConvException("数据字典配置错误");
				}
				String lenType = p8583Dic.getLenType();
				if (lenType == null) {
					throw new Pack8583ConvException("数据字典配置错误");
				}
				Object dataValue = dataMap.get(dataCode);
				if (dataValue != null) {
					bitMap[4 + i] ^= 0X80 >> j;
					byte[] dst = null;
					dst = packDataConv(dataValue, dataType, lenType, p8583Dic.getDataLen(), p8583Dic.getDataDec(),
							p8583Dic.getFormat(), charsetName, p8583Dic.getBitSeq().isMab(), mab);
					dataArea = dataArea == null ? dst : joinByteArray(dataArea, dst);
					logger.info("第[" + bitSeq + "]位BIT值为[" + dataValue + "][" + dst.length + "]");
				}
			}
		}

		String bitMapHex = DigestUtil.byteToHex(bitMap);
		String bitMapBin = DigestUtil.byteToBin(bitMap);
		logger.info("BITMAP 16进制=[" + bitMapHex.substring(8) + "][" + (bitMapHex.length() - 8) + "]");
		logger.info("BITMAP   2进制=[" + bitMapBin.substring(32) + "][" + (bitMapBin.length() - 32) + "]");

		dataMap.put("MAB", mab.toString().trim());

		return joinByteArray(bitMap, dataArea);

	}

	private byte[] packDataConv(Object dataValue, String dataType, String lenType, int dataLen, int dataDec,
			String format, String charsetName, Boolean isMab, StringBuffer mab) throws Pack8583ConvException {
		String value = null;
		switch (dataType.charAt(0)) {
		case 'A': // 字符
			if (format != null && format.equals("space")) {
				value = DataUtil.fillSpaceRight((String) dataValue, dataLen);
			} else {
				value = (String) dataValue;
			}
			break;
		case 'B': // 二进制
			try {
				value = new String((byte[]) dataValue, charsetName);
			} catch (UnsupportedEncodingException e) {
				throw new Pack8583ConvException("不支持的编码" + charsetName + e);
			}
			break;
		case 'N': // 数值
			if (format != null && format.equals("zero")) {
				value = DataUtil.fillZeroLeft((Integer) dataValue, dataLen);
			} else {
				value = String.valueOf((Integer) dataValue);
			}
			break;
		case 'D': // 金额
			if (format != null && format.equals("point")) {
				value = DataUtil.removePoint((Double) dataValue, dataLen, dataDec);
			} else {
				value = String.valueOf((Double) dataValue);
			}
			break;
		default:
			throw new Pack8583ConvException("不支持的数据类型" + dataType);
		}
		
		byte[] dataByte = null;
		try {
			dataByte = value.getBytes(charsetName);
		} catch (UnsupportedEncodingException e) {
			throw new Pack8583ConvException("不支持的编码" + charsetName + e);
		}
		
		byte[] dst = null;
		Integer type = Integer.valueOf(lenType);
		switch (type) {
		case 0:
			dst = dataByte;
			if (dst.length != dataLen) {
				throw new Pack8583ConvException("源数据长度错误[" + dst.length + "|" + dataLen + "]");
			}
			break;
		case 1:
		case 2:
		case 3:
			int len = dataByte.length;
			if (len > dataLen) {
				throw new Pack8583ConvException("源数据长度错误[" + len + "|" + dataLen + "]");
			}
			dst = new byte[type + len];
			System.arraycopy(DataUtil.fillZeroLeft(len, type).getBytes(), 0, dst, 0, type);
			System.arraycopy(dataByte, 0, dst, type, len);
			break;
		default:
			throw new Pack8583ConvException("不支持的长度类型" + lenType);
		}

		if (isMab) {
			try {
				mab.append(String.valueOf(new String(dst, charsetName) + " "));
			} catch (UnsupportedEncodingException e) {
				throw new Pack8583ConvException("不支持的编码格式[" + charsetName + "]" + e);
			}
		}

		return dst;
	}

	private byte[] joinByteArray(byte[] bitMap, byte[] dataByte) {
		ByteBuffer pack8583 = ByteBuffer.allocate(bitMap.length + dataByte.length);
		pack8583.put(bitMap);
		pack8583.put(dataByte);
		return pack8583.array();
	}

	public Map<String, Object> toMap(byte[] dataPack) throws Unpack8583ConvException {
		return toMap(dataPack, this.pack8583DicMap.getBitMapLen(), this.pack8583DicMap.getCharsetName());
	}

	private Map<String, Object> toMap(byte[] dataPack, int bitMapLen, String charsetName)
			throws Unpack8583ConvException {
		StringBuffer mab = new StringBuffer();
		int mapLen = bitMapLen / 8;
		Map<String, Object> map = new HashMap<String, Object>();
		byte[] msgId = new byte[4];
		System.arraycopy(dataPack, 0, msgId, 0, 4);
		logger.info("MSGID=[" + new String(msgId) + "]");
		map.put("MSGID", new String(msgId));
		byte[] bitMap = new byte[mapLen];
		System.arraycopy(dataPack, 4, bitMap, 0, bitMap.length);
		String bitMapHex = DigestUtil.byteToHex(bitMap);
		String bitMapBin = DigestUtil.byteToBin(bitMap);
		logger.info("BITMAP 16进制=[" + bitMapHex + "][" + bitMapHex.length() + "]");
		logger.info("BITMAP   2进制=[" + bitMapBin + "][" + bitMapBin.length() + "]");
		ByteBuffer dataArea = ByteBuffer.allocate(dataPack.length - mapLen);
		dataArea.put(dataPack, mapLen + 4, dataPack.length - mapLen - 4);
		dataArea.flip();
		for (int i = 0; i < mapLen; ++i) {
			for (int j = 0; j < 8; ++j) {
				int bitSeq = i * 8 + j + 1;
				if (bitSeq == 1) { // 处理第一位bit图
					if ((bitMap[i] & (0X80 >> j)) == 0x00 && bitMapLen == 128) {
						throw new Unpack8583ConvException("第一位Bit图异常");
					}
					continue;
				}
				if ((bitMap[i] & (0X80 >> j)) == 0x00) {
					continue;
				}
				Pack8583Dic p8583Dic = dataDicMap.get(bitSeq);
				if (p8583Dic == null) {
					throw new Unpack8583ConvException("数据字典缺失[" + bitSeq + "]");
				}
				String dataType = p8583Dic.getDataType();
				if (dataType == null) {
					throw new Unpack8583ConvException("数据字典缺失[" + bitSeq + "]");
				}
				String lenType = p8583Dic.getLenType();
				if (lenType == null) {
					throw new Unpack8583ConvException("数据字典缺失[" + bitSeq + "]");
				}
				String dataCode = p8583Dic.getDataCode();
				if (dataCode == null) {
					throw new Unpack8583ConvException("数据字典缺失[" + bitSeq + "]");
				}
				Object dataValue = null;
				dataValue = unPackDataConv(dataArea, dataType, lenType, p8583Dic.getDataLen(), p8583Dic.getDataDec(),
						p8583Dic.getFormat(), charsetName, p8583Dic.getBitSeq().isMab(), mab);

				logger.info("第[" + bitSeq + "]位BIT值为[" + dataValue + "][" + p8583Dic.getDataLen() + "]");
				map.put(dataCode, dataValue);

			}
		}

		map.put("MAB", mab.toString().trim());

		return map;
	}

	private Object unPackDataConv(ByteBuffer dataArea, String dataType, String lenType, int dataLen, int dataDec,
			String format, String charsetName, Boolean isMab, StringBuffer mab) throws Unpack8583ConvException {
		byte[] dst = null;
		byte[] bLen = null;
		Integer type = Integer.valueOf(lenType);
		switch (type) {
		case 0:
			dst = new byte[dataLen];
			if (dst.length != dataLen) {
				throw new Unpack8583ConvException("源数据长度错误[" + dst.length + "|" + dataLen + "]");
			}
			dataArea.get(dst, 0, dataLen);
			break;
		case 1:
		case 2:
		case 3:
			bLen = new byte[type];
			dataArea.get(bLen, 0, type);
			int len = Integer.valueOf(new String(bLen));
			if (len > dataLen) {
				throw new Unpack8583ConvException("报文数据长度错误[" + len + "|" + dataLen + "]");
			}
			dst = new byte[len];
			dataArea.get(dst, 0, len);
			break;
		default:
			throw new Unpack8583ConvException("不支持的编码" + lenType);
		}

		if (isMab) {
			try {
				if (bLen != null) {
					mab.append(String.valueOf(new String(bLen, charsetName)));
				}
				mab.append(String.valueOf(new String(dst, charsetName) + " "));
			} catch (UnsupportedEncodingException e) {
				throw new Unpack8583ConvException("不支持的编码格式[" + charsetName + "]" + e);
			}
		}

		Object dataValue = null;
		switch (dataType.charAt(0)) {
		case 'A': // 字符
			try {
				dataValue = new String(dst, charsetName).trim();
			} catch (UnsupportedEncodingException e) {
				throw new Unpack8583ConvException("不支持的编码格式[" + charsetName + "]" + e);
			}
			break;
		case 'B': // 二进制
			dataValue = dst;
			break;
		case 'N': // 数值
			dataValue = Integer.valueOf(new String(dst));
			break;
		case 'D': // 金额
			double money = Double.valueOf(new String(dst));
			if (format != null && format.equals("point")) {
				dataValue = DataUtil.addPoint(money, dataLen, dataDec);
			} else {
				dataValue = money;
			}
			break;
		default:
			throw new Unpack8583ConvException("不支持的数据类型" + dataType);
		}

		return dataValue;
	}

}
