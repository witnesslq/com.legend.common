package com.legend.common.config.databus;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dataDic"
})
@XmlRootElement(name = "DataDicMap")
public class DataDicMap {

    @XmlElement(name = "DataDic", required = true)
    protected List<DataDic> dataDic;


    public List<DataDic> getDataDic() {
        if (dataDic == null) {
            dataDic = new ArrayList<DataDic>();
        }
        return this.dataDic;
    }


}