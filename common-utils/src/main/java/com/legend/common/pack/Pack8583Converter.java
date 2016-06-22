package com.legend.common.pack;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.exception.Pack8583Exception;
import com.legend.common.utils.DigestUtil;

public class Pack8583Converter {

	private static Logger logger = LoggerFactory.getLogger(Pack8583Converter.class);

	private Map<Integer, Pack8583Dic> dataDic; // 8583数据字典

	public Pack8583Converter(Map<Integer, Pack8583Dic> dataDic){
		this.dataDic = dataDic;
	}

	public byte[] to8583_64(Map<String, Object> dataMap) throws Pack8583Exception {
		return to8583(dataMap, 64, "UTF-8");
	}

	public byte[] to8583_128(Map<String, Object> dataMap) throws Pack8583Exception {
		return to8583(dataMap, 128, "UTF-8");
	}

	private byte[] to8583(Map<String, Object> dataMap, int bitMapLen, String charsetName)
			throws Pack8583Exception {
		int mapLen = bitMapLen / 8;
		byte[] bitMap = new byte[mapLen];
		byte[] dataArea = null;
		for (int i = 0; i < mapLen; ++i) {
			bitMap[i] = 0X00;
			for (int j = 0; j < 8; ++j) {
				int bitSeq = i * 8 + j + 1;
				Pack8583Dic p8583Dic = dataDic.get(bitSeq);
				if (p8583Dic == null) {
					logger.error("数据字典缺失[" + bitSeq + "]");
					throw new Pack8583Exception("数据字典缺失");
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
					bitMap[i] ^= 0X80 >> j;
					byte[] dst = null;
					try {
						dst = packDataConv(dataValue, dataType, lenType, p8583Dic.getDataLen(), p8583Dic.getDataDec(),
								charsetName);
					} catch (UnsupportedEncodingException e) {
						logger.error("第[" + bitSeq + "]位BIT值为[" + dataValue + "][" + charsetName + "]");
						throw new Pack8583Exception(e);
					}
					dataArea = dataArea == null ? dst : joinByteArray(dataArea, dst);
					logger.info("第[" + bitSeq + "]位BIT值为[" + dataValue + "][" + dst.length + "]");
				}
			}
		}

		String bitMapHex = DigestUtil.byteToHex(bitMap);
		String bitMapBin = DigestUtil.byteToBin(bitMap);
		logger.info("BITMAP 16进制=[" + bitMapHex + "][" + bitMapHex.length() + "]");
		logger.info("BITMAP   2进制=[" + bitMapBin + "][" + bitMapBin.length() + "]");

		return joinByteArray(bitMap, dataArea);

	}

	private byte[] packDataConv(Object dataValue, String dataType, String lenType, int dataLen, int dataDec,
			String charsetName) throws UnsupportedEncodingException {
		//TODO
		String s = (String) dataValue;
		byte[] dataByte = null;
		try {
			dataByte = s.getBytes(charsetName);
		} catch (UnsupportedEncodingException e) {
			throw new UnsupportedEncodingException("不支持的编码" + charsetName + e);
		}
		byte[] dst = new byte[dataLen];
		// 依据数据类型进行初始化，暂时都初始化成空格，得考虑左对齐，右对齐，补空格还是0
		for (int k = 0; k < dataLen; ++k) {
			dst[k] = 0X20;
		}
		int copyLen = dataByte.length < dataLen ? dataByte.length : dataLen;
		int begLen = copyLen > dataLen ? copyLen - dataLen : dataLen - copyLen;
		System.arraycopy(dataByte, 0, dst, begLen, copyLen);
		return dst;
	}

	private byte[] joinByteArray(byte[] bitMap, byte[] dataByte) {
		ByteBuffer pack8583 = ByteBuffer.allocate(bitMap.length + dataByte.length);
		pack8583.put(bitMap);
		pack8583.put(dataByte);
		return pack8583.array();
	}

	public Map<String, Object> toMap_64(byte[] dataPack) throws Pack8583Exception {
		return toMap(dataPack, 64, "UTF-8");
	}

	public Map<String, Object> toMap_128(byte[] dataPack) throws Pack8583Exception {
		return toMap(dataPack, 128, "UTF-8");
	}

	private Map<String, Object> toMap(byte[] dataPack, int bitMapLen, String charsetName)
			throws Pack8583Exception {
		int mapLen = bitMapLen / 8;
		Map<String, Object> map = new HashMap<String, Object>();
		byte[] bitMap = new byte[mapLen];
		System.arraycopy(dataPack, 0, bitMap, 0, bitMap.length);
		String bitMapHex = DigestUtil.byteToHex(bitMap);
		String bitMapBin = DigestUtil.byteToBin(bitMap);
		logger.info("BITMAP 16进制=[" + bitMapHex + "][" + bitMapHex.length() + "]");
		logger.info("BITMAP   2进制=[" + bitMapBin + "][" + bitMapBin.length() + "]");
		ByteBuffer dataArea = ByteBuffer.allocate(dataPack.length - mapLen);
		dataArea.put(dataPack, mapLen, dataPack.length - mapLen);
		dataArea.flip();
		for (int i = 0; i < mapLen; ++i) {
			for (int j = 0; j < 8; ++j) {
				int bitSeq = i * 8 + j + 1;
				if ((bitMap[i] & (0X80 >> j)) == 0x00) {
					continue;
				}
				Pack8583Dic p8583Dic = dataDic.get(bitSeq);
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
							p8583Dic.getDataDec(), charsetName);
				} catch (UnsupportedEncodingException e) {
					logger.error("第[" + bitSeq + "]位BIT值为[" + dataValue + "][" + charsetName + "]");
					throw new Pack8583Exception(e);
				}

				logger.info("第[" + bitSeq + "]位BIT值为[" + dataValue + "][" + p8583Dic.getDataLen() + "]");
				map.put(dataCode, dataValue);
			}
		}

		return map;
	}

	private Object unPackDataConv(ByteBuffer dataArea, String dataType, String lenType, int dataLen, int dataDec,
			String charsetName) throws UnsupportedEncodingException {
		//TODO
		Object dataValue = null;
		byte[] dst = new byte[dataLen];
		dataArea.get(dst, 0, dataLen);
		try {
			dataValue = new String(dst, charsetName);
		} catch (UnsupportedEncodingException e) {
			throw new UnsupportedEncodingException("不支持的编码" + charsetName + e);
		}
		return dataValue;
	}

}

