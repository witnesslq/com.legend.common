package com.legend.common.pack.p8583;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bitSeq",
    "dataCode",
    "dataType",
    "lenType",
    "dataLen",
    "dataDec",
    "desc",
    "mabTag",
    "format"
})
class Pack8583Dic {

	@XmlElement(name = "BitSeq", required = true)
	private int bitSeq; 

	@XmlElement(name = "DataCode", required = true)
	private String dataCode; // 数据编码

	@XmlElement(name = "DataType", required = true)
	private String dataType; // 数据类型(0:二进制；1:数值；2:字符)

	@XmlElement(name = "LenType", required = true)
	private String lenType; // 数据长度类型(0:定长;1:1位变长;2:2位变长3:3位变长)

	@XmlElement(name = "DataLen", required = true)
	private int dataLen; // 数据长度

	@XmlElement(name = "DataDec", required = true)
	private int dataDec; // 数据小数位数

	@XmlElement(name = "Desc", required = true)
	private String desc; // 说明

	@XmlElement(name = "MabTag", required = true)
	private Boolean mabTag;

	@XmlElement(name = "Format", required = true)
	private String format;


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

	public Boolean getMabTag() {
		return mabTag;
	}

	public void setMabTag(Boolean mabTag) {
		this.mabTag = mabTag;
	}

	public String getFormat() {
		return format;
	}

	public void setFormatClass(String format) {
		this.format = format;
	}
	
	

}
