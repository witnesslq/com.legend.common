package com.legend.common.config.system.target;

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
