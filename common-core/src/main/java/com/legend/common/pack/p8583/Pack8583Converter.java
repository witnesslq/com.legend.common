package com.legend.common.pack.p8583;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.exception.DataConvException;
import com.legend.common.exception.Pack8583Exception;
import com.legend.common.utils.DataUtil;
import com.legend.common.utils.DigestUtil;

public class Pack8583Converter {

	private static Logger logger = LoggerFactory.getLogger(Pack8583Converter.class);

	private Map<Integer, Pack8583Dic> dataDicMap; // 8583数据字典
	private Pack8583DicMap pack8583DicMap;

	/*
	 * 使用spring构造函数注入
	 */
	public Pack8583Converter(String dataDicFileName) throws Pack8583Exception {
		String dataDicFilePath = null;
		try {
			JAXBContext jc = JAXBContext.newInstance(Pack8583DicMap.class);
			Unmarshaller ums = jc.createUnmarshaller();
			dataDicFilePath = Pack8583Converter.class.getClassLoader().getResource(dataDicFileName).getPath();
			logger.info("装载8583数据字典[" + dataDicFilePath + "]");
			this.pack8583DicMap = (Pack8583DicMap) ums.unmarshal(new File(dataDicFilePath));
		} catch (JAXBException e) {
			logger.error("读取数据字典配置文件错误[" + dataDicFilePath + "][" + dataDicFileName + "]" + e);
			throw new Pack8583Exception("读取数据字典配置文件错误" + e);
		}

		this.dataDicMap = new LinkedHashMap<Integer, Pack8583Dic>();
		List<Pack8583Dic> pack8583Dics = this.pack8583DicMap.getPack8583Dic();
		for (Pack8583Dic pack8583Dic : pack8583Dics) {
			this.dataDicMap.put(pack8583Dic.getBitSeq().getValue(), pack8583Dic);
		}
		logger.info("8583报文数据字典初始化完成");
	}

	public byte[] to8583(Map<String, Object> dataMap) throws Pack8583Exception {
		return to8583(dataMap, this.pack8583DicMap.getBitMapLen(), this.pack8583DicMap.getCharsetName());
	}

	private byte[] to8583(Map<String, Object> dataMap, int bitMapLen, String charsetName) throws Pack8583Exception {
		StringBuffer mab = new StringBuffer();
		int mapLen = bitMapLen / 8;
		String msgId = (String) dataMap.get("MSGID");
		logger.info("MSGID=[" + msgId + "]");
		if(msgId==null){
			logger.error("MSGID未设置");
			throw new Pack8583Exception("MSGID未设置");
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
					logger.error("数据字典配置错误[" + bitSeq + "]");
					throw new Pack8583Exception("数据字典配置错误");
				}
				String dataType = p8583Dic.getDataType();
				if (dataType == null) {
					logger.error("数据字典配置错误[" + bitSeq + "]");
					throw new Pack8583Exception("数据字典配置错误");
				}
				String lenType = p8583Dic.getLenType();
				if (lenType == null) {
					logger.error("数据字典配置错误[" + bitSeq + "]");
					throw new Pack8583Exception("数据字典配置错误");
				}
				Object dataValue = dataMap.get(dataCode);
				if (dataValue != null) {
					bitMap[4 + i] ^= 0X80 >> j;
					byte[] dst = null;
					try {
						dst = packDataConv(dataValue, dataType, lenType, p8583Dic.getDataLen(), p8583Dic.getDataDec(),
								p8583Dic.getFormat(), charsetName, p8583Dic.getBitSeq().isMab(), mab);
					} catch (DataConvException e) {
						logger.error("数据转换错误：[" + bitSeq + "][" + dataValue + "][" + charsetName + "]");
						throw new Pack8583Exception(e);
					}
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
			String format, String charsetName, Boolean isMab, StringBuffer mab) throws DataConvException {
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
				logger.error("不支持的编码" + charsetName + e);
				throw new DataConvException("不支持的编码" + charsetName + e);
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
			logger.error("不支持的数据类型" + dataType);
			throw new DataConvException("不支持的数据类型" + dataType);
		}
		byte[] dataByte = null;
		try {
			dataByte = value.getBytes(charsetName);
		} catch (UnsupportedEncodingException e) {
			logger.error("不支持的编码" + charsetName + e);
			throw new DataConvException("不支持的编码" + charsetName + e);
		}
		byte[] dst = null;
		Integer type = Integer.valueOf(lenType);
		switch (type) {
		case 0:
			dst = dataByte;
			if (dst.length != dataLen) {
				logger.error("源数据长度错误[" + dst.length + "|" + dataLen + "]");
				throw new DataConvException("源数据长度错误[" + dst.length + "|" + dataLen + "]");
			}
			break;
		case 1:
		case 2:
		case 3:
			int len = dataByte.length;
			if (len > dataLen) {
				logger.error("源数据长度错误[" + len + "|" + dataLen + "]");
				throw new DataConvException("源数据长度错误[" + len + "|" + dataLen + "]");
			}
			dst = new byte[type + len];
			System.arraycopy(DataUtil.fillZeroLeft(len, type).getBytes(), 0, dst, 0, type);
			System.arraycopy(dataByte, 0, dst, type, len);
			break;
		default:
			logger.error("不支持的长度类型" + lenType);
			throw new DataConvException("不支持的编码" + lenType);
		}

		if (isMab) {
			try {
				mab.append(String.valueOf(new String(dst, charsetName) + " "));
			} catch (UnsupportedEncodingException e) {
				logger.error("不支持的编码格式" + charsetName + e);
				throw new DataConvException("不支持的编码格式" + charsetName + e);
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

	public Map<String, Object> toMap(byte[] dataPack) throws Pack8583Exception {
		return toMap(dataPack, this.pack8583DicMap.getBitMapLen(), this.pack8583DicMap.getCharsetName());
	}

	private Map<String, Object> toMap(byte[] dataPack, int bitMapLen, String charsetName) throws Pack8583Exception {
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
						logger.error("第一位Bit图异常");
						throw new Pack8583Exception("第一位Bit图异常");
					}
					continue;
				}
				if ((bitMap[i] & (0X80 >> j)) == 0x00) {
					continue;
				}
				Pack8583Dic p8583Dic = dataDicMap.get(bitSeq);
				if (p8583Dic == null) {
					logger.error("数据字典缺失[" + bitSeq + "]");
					throw new Pack8583Exception("数据字典缺失");
				}
				String dataType = p8583Dic.getDataType();
				if (dataType == null) {
					logger.error("数据字典配置错误[" + bitSeq + "]");
					throw new Pack8583Exception("数据字典配置错误");
				}
				String lenType = p8583Dic.getLenType();
				if (lenType == null) {
					logger.error("数据字典配置错误[" + bitSeq + "]");
					throw new Pack8583Exception("数据字典配置错误");
				}
				String dataCode = p8583Dic.getDataCode();
				if (dataCode == null) {
					logger.error("数据字典配置错误[" + bitSeq + "]");
					throw new Pack8583Exception("数据字典配置错误");
				}
				Object dataValue = null;
				try {
					dataValue = unPackDataConv(dataArea, dataType, lenType, p8583Dic.getDataLen(),
							p8583Dic.getDataDec(), p8583Dic.getFormat(), charsetName, p8583Dic.getBitSeq().isMab(),
							mab);
				} catch (DataConvException e) {
					logger.error("第[" + bitSeq + "]位BIT值为[" + dataValue + "][" + charsetName + "]");
					throw new Pack8583Exception(e);
				}

				logger.info("第[" + bitSeq + "]位BIT值为[" + dataValue + "][" + p8583Dic.getDataLen() + "]");
				map.put(dataCode, dataValue);

			}
		}

		map.put("MAB", mab.toString().trim());

		return map;
	}

	private Object unPackDataConv(ByteBuffer dataArea, String dataType, String lenType, int dataLen, int dataDec,
			String format, String charsetName, Boolean isMab, StringBuffer mab) throws DataConvException {
		byte[] dst = null;
		byte[] bLen = null;
		Integer type = Integer.valueOf(lenType);
		switch (type) {
		case 0:
			dst = new byte[dataLen];
			if (dst.length != dataLen) {
				logger.error("源数据长度错误[" + dst.length + "|" + dataLen + "]");
				throw new DataConvException("源数据长度错误[" + dst.length + "|" + dataLen + "]");
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
				logger.error("报文数据长度错误[" + len + "|" + dataLen + "]");
				throw new DataConvException("报文数据长度错误[" + len + "|" + dataLen + "]");
			}
			dst = new byte[len];
			dataArea.get(dst, 0, len);
			break;
		default:
			logger.error("不支持的长度类型" + lenType);
			throw new DataConvException("不支持的编码" + lenType);
		}

		if (isMab) {
			try {
				if (bLen != null) {
					mab.append(String.valueOf(new String(bLen, charsetName)));
				}
				mab.append(String.valueOf(new String(dst, charsetName) + " "));
			} catch (UnsupportedEncodingException e) {
				logger.error("不支持的编码格式" + charsetName + e);
				throw new DataConvException("不支持的编码格式" + charsetName + e);
			}
		}

		Object dataValue = null;
		switch (dataType.charAt(0)) {
		case 'A': // 字符
			dataValue = new String(dst).trim();
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
			logger.error("不支持的数据类型" + dataType);
			throw new DataConvException("不支持的数据类型" + dataType);
		}

		return dataValue;
	}

}
