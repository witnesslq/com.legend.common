package com.legend.common.config.rspcode;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rspCode"
})
@XmlRootElement(name = "RspCodeMap")
public class RspCodeMap {

    @XmlElement(name = "RspCode", required = true)
    protected List<RspCode> rspCode;
    @XmlAttribute(name = "defaultErrorInCode", required = true)
    protected String defaultErrorInCode;
    @XmlAttribute(name = "defaultErrorOutCode", required = true)
    protected String defaultErrorOutCode;

    public List<RspCode> getRspCode() {
        if (rspCode == null) {
            rspCode = new ArrayList<RspCode>();
        }
        return this.rspCode;
    }

    public String getDefaultErrorInCode() {
        return defaultErrorInCode;
    }

    public void setDefaultErrorInCode(String value) {
        this.defaultErrorInCode = value;
    }

    public String getDefaultErrorOutCode() {
        return defaultErrorOutCode;
    }

    public void setDefaultErrorOutCode(String value) {
        this.defaultErrorOutCode = value;
    }


 
}
