//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2016.06.17 ʱ�� 03:58:59 PM CST 
//


package com.legend.common.model.beps.beps_121_001_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Identification1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Identification1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Othr" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Other1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Identification1", propOrder = {
    "othr"
})
public class Identification1 {

    @XmlElement(name = "Othr", required = true)
    protected Other1 othr;

    /**
     * ��ȡothr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Other1 }
     *     
     */
    public Other1 getOthr() {
        return othr;
    }

    /**
     * ����othr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Other1 }
     *     
     */
    public void setOthr(Other1 value) {
        this.othr = value;
    }

}
