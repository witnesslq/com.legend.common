package com.legend.common.config.system.target;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CodecFactory_Restriction")
@XmlEnum
public enum CodecFactoryRestriction {

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
