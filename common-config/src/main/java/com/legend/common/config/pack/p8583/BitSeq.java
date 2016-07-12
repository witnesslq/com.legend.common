package com.legend.common.config.pack.p8583;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "value" })
public class BitSeq {

	@XmlValue
	protected int value;
	@XmlAttribute(name = "mab")
	protected Boolean mab = false;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Boolean isMab() {
		return mab;
	}

	public void setMab(Boolean value) {
		this.mab = value;
	}

}