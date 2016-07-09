package com.legend.common.core.databus.dataconv;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "Format_Restriction")
@XmlEnum
public enum FormatRestriction {

    @XmlEnumValue("point")
    POINT("point");
    private final String value;

    FormatRestriction(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FormatRestriction fromValue(String v) {
        for (FormatRestriction c: FormatRestriction.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
