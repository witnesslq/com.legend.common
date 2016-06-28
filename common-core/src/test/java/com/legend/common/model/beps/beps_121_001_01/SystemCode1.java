//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2016.06.17 ʱ�� 03:58:59 PM CST 
//


package com.legend.common.model.beps.beps_121_001_01;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SystemCode1�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="SystemCode1">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SAPS"/>
 *     &lt;enumeration value="HVPS"/>
 *     &lt;enumeration value="BEPS"/>
 *     &lt;enumeration value="CCMS"/>
 *     &lt;enumeration value="PMIS"/>
 *     &lt;enumeration value="IBPS"/>
 *     &lt;enumeration value="NCIS"/>
 *     &lt;enumeration value="ECDS"/>
 *     &lt;enumeration value="FXPS"/>
 *     &lt;enumeration value="NETS"/>
 *     &lt;enumeration value="PBCS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SystemCode1")
@XmlEnum
public enum SystemCode1 {

    SAPS,
    HVPS,
    BEPS,
    CCMS,
    PMIS,
    IBPS,
    NCIS,
    ECDS,
    FXPS,
    NETS,
    PBCS;

    public String value() {
        return name();
    }

    public static SystemCode1 fromValue(String v) {
        return valueOf(v);
    }

}
