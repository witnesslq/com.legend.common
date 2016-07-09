package com.legend.common.core.databus.dataconv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "source", "destination", "format" })
public class DataConv {

	@XmlElement(name = "Source", required = true)
	protected DataConv.Source source;
	@XmlElement(name = "Destination", required = true)
	protected String destination;
	@XmlElement(name = "Format")
	protected DataConv.Format format;

	public DataConv.Source getSource() {
		return source;
	}

	public void setSource(DataConv.Source value) {
		this.source = value;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String value) {
		this.destination = value;
	}

	public DataConv.Format getFormat() {
		return format;
	}

	public void setFormat(DataConv.Format value) {
		this.format = value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "value" })
	public static class Format {

		@XmlValue
		protected FormatRestriction value;
		@XmlAttribute(name = "dec")
		protected Integer dec;

		public FormatRestriction getValue() {
			return value;
		}

		public void setValue(FormatRestriction value) {
			this.value = value;
		}

		public Integer getDec() {
			return dec;
		}

		public void setDec(Integer value) {
			this.dec = value;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "value" })
	public static class Source {

		@XmlValue
		protected String value;
		@XmlAttribute(name = "from")
		protected String from;
		@XmlAttribute(name = "type")
		protected String type;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getFrom() {
			if (from == null) {
				return "databus";
			} else {
				return from;
			}
		}

		public void setFrom(String from) {
			this.from = from;
		}
		
		public String getType() {
			if (type == null) {
				return "string";
			} else {
				return type;
			}
		}

		public void setType(String value) {
			this.type = value;
		}

	}

}
