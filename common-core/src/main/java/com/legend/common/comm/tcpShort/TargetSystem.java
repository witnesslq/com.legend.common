

package com.legend.common.comm.tcpShort;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "targetIp",
    "targetPort",
    "waitTimeout",
    "useLog",
    "codecFactory"
})
@XmlRootElement(name = "TargetSystem")
public class TargetSystem {

    @XmlElement(name = "TargetIp", required = true)
    protected String targetIp;
    @XmlElement(name = "TargetPort")
    protected int targetPort;
    @XmlElement(name = "WaitTimeout")
    protected int waitTimeout;
    protected boolean useLog;
    @XmlElement(name = "CodecFactory", required = true)
    protected CodecFactory codecFactory;

    public String getTargetIp() {
        return targetIp;
    }

    public void setTargetIp(String value) {
        this.targetIp = value;
    }

    public int getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(int value) {
        this.targetPort = value;
    }

    public int getWaitTimeout() {
        return waitTimeout;
    }

    public void setWaitTimeout(int value) {
        this.waitTimeout = value;
    }

    public boolean isUseLog() {
        return useLog;
    }

    public void setUseLog(boolean value) {
        this.useLog = value;
    }

    public CodecFactory getCodecFactory() {
        return codecFactory;
    }

    public void setCodecFactory(CodecFactory value) {
        this.codecFactory = value;
    }


}
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value",
	"charsetName"
})
class CodecFactory {

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


@XmlType(name = "CodecFactory_Restriction")
@XmlEnum
enum CodecFactoryRestriction {

    @XmlEnumValue("LenValueCodecFactory")
    LEN_VALUE_CODEC_FACTORY("LenValueCodecFactory");
    private final String value;

    CodecFactoryRestriction(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CodecFactoryRestriction fromValue(String v) {
        for (CodecFactoryRestriction c: CodecFactoryRestriction.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
