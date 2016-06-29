package com.legend.common.databus.dataconv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "source", "destination" })
public class DataConv {

	@XmlElement(name = "Source", required = true)
	protected String source;
	@XmlElement(name = "Destination", required = true)
	protected String destination;

	public String getSource() {
		return source;
	}

	public void setSource(String value) {
		this.source = value;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String value) {
		this.destination = value;
	}

}