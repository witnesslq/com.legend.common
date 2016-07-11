package com.legend.common.config.pack.p8583;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { 
		"bitSeq", 
		"dataCode", 
		"dataType", 
		"lenType", 
		"dataLen", 
		"dataDec", 
		"desc", 
		"format" })
public class Pack8583Dic {

	@XmlElement(name = "BitSeq", required = true)
	protected BitSeq bitSeq;
	@XmlElement(name = "DataCode", required = true)
	protected String dataCode;
	@XmlElement(name = "DataType", required = true)
	protected String dataType;
	@XmlElement(name = "LenType", required = true)
	protected String lenType;
	@XmlElement(name = "DataLen")
	protected int dataLen;
	@XmlElement(name = "DataDec")
	protected int dataDec;
	@XmlElement(name = "Desc", required = true)
	protected String desc;
	@XmlElement(name = "Format")
	protected String format;

	public BitSeq getBitSeq() {
		return bitSeq;
	}

	public void setBitSeq(BitSeq value) {
		this.bitSeq = value;
	}

	public String getDataCode() {
		return dataCode;
	}

	public void setDataCode(String value) {
		this.dataCode = value;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String value) {
		this.dataType = value;
	}

	public String getLenType() {
		return lenType;
	}

	public void setLenType(String value) {
		this.lenType = value;
	}

	public int getDataLen() {
		return dataLen;
	}

	public void setDataLen(int value) {
		this.dataLen = value;
	}

	public int getDataDec() {
		return dataDec;
	}

	public void setDataDec(int value) {
		this.dataDec = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String value) {
		this.desc = value;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String value) {
		this.format = value;
	}

}
