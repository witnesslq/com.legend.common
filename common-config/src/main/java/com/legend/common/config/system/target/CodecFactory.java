package com.legend.common.config.system.target;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value",
	"charsetName"
})
public class CodecFactory {

    @XmlValue
    protected CodecFactoryRestriction value;
    @XmlAttribute(name = "len")
    protected int len;
    
    @XmlAttribute(name = "charsetName")
    protected String charsetName;

    public CodecFactoryRestriction getValue() {
        return value;
    }

    public void setValue(CodecFactoryRestriction value) {
        this.value = value;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int value) {
        this.len = value;
    }

	public String getCharsetName() {
		return charsetName;
	}

	public void setCharsetName(String charsetName) {
		this.charsetName = charsetName;
	}

}
