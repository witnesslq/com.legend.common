package com.legend.common.core.rspcode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "inner",
    "outter"
})
public class RspCode {

    @XmlElement(name = "Inner", required = true)
    protected String inner;
    @XmlElement(name = "Outter", required = true)
    protected String outter;

    public String getInner() {
        return inner;
    }

    public void setInner(String value) {
        this.inner = value;
    }

    public String getOutter() {
        return outter;
    }

    public void setOutter(String value) {
        this.outter = value;
    }

}
