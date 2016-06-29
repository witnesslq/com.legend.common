package com.legend.common.databus.datadic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dataCode",
    "dataType",
    "desc"
})
public class DataDic {

    @XmlElement(name = "DataCode", required = true)
    protected String dataCode;
    @XmlElement(name = "DataType", required = true)
    protected String dataType;
    @XmlElement(name = "Desc", required = true)
    protected String desc;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String value) {
        this.desc = value;
    }

}
