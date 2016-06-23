package com.legend.common.pack.p8583;

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
    "pack8583Dic"
})
@XmlRootElement(name = "Pack8583DicMap")
public class Pack8583DicMap {

    @XmlElement(name = "Pack8583Dic", required = true)
    private List<Pack8583Dic> pack8583Dic;
    
    @XmlAttribute(name = "bitMapLen")
    private int bitMapLen;
    
    @XmlAttribute(name = "bitMapVisable")
    private Boolean bitMapVisable;

    public List<Pack8583Dic> getPack8583Dic() {
        if (pack8583Dic == null) {
            pack8583Dic = new ArrayList<Pack8583Dic>();
        }
        return this.pack8583Dic;
    }
    
    public Boolean isBitMapVisable() {
        return bitMapVisable;
    }

    public void setBitMapVisable(Boolean value) {
        this.bitMapVisable = value;
    }

    public int getBitMapLen() {
        return bitMapLen;
    }

    public void setBitMapLen(int value) {
        this.bitMapLen = value;
    }
}
