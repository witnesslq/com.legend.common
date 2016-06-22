package com.legend.common.pack;

public class Pack8583Dic {

	private int bitSeq; // 序号
	private String dataCode; // 数据编码
	private String dataType; // 数据类型(1:整型2:长整型3:单精度浮点型4:双精度浮点型5:金额型)
	private String lenType; // 数据长度类型(1:定长2:2位变长3:3位变长)
	private int dataLen; // 数据长度
	private int dataDec; // 数据小数位数
	private String desc; // 说明

	public Pack8583Dic(int bitSeq, String dataCode, String dataType, String lenType, int dataLen, int dataDec,
			String desc) {
		super();
		this.bitSeq = bitSeq;
		this.dataCode = dataCode;
		this.dataType = dataType;
		this.lenType = lenType;
		this.dataLen = dataLen;
		this.dataDec = dataDec;
		this.desc = desc;
	}

	public int getBitSeq() {
		return bitSeq;
	}

	public void setBitSeq(int bitSeq) {
		this.bitSeq = bitSeq;
	}

	public String getDataCode() {
		return dataCode;
	}

	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getLenType() {
		return lenType;
	}

	public void setLenType(String lenType) {
		this.lenType = lenType;
	}

	public int getDataLen() {
		return dataLen;
	}

	public void setDataLen(int dataLen) {
		this.dataLen = dataLen;
	}

	public int getDataDec() {
		return dataDec;
	}

	public void setDataDec(int dataDec) {
		this.dataDec = dataDec;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


}
