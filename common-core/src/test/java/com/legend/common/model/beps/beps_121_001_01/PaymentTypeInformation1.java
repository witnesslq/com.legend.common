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
 * <p>PaymentTypeInformation1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PaymentTypeInformation1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CtgyPurp" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}CategoryPurpose1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTypeInformation1", propOrder = {
    "ctgyPurp"
})
public class PaymentTypeInformation1 {

    @XmlElement(name = "CtgyPurp", required = true)
    protected CategoryPurpose1 ctgyPurp;

    /**
     * ��ȡctgyPurp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CategoryPurpose1 }
     *     
     */
    public CategoryPurpose1 getCtgyPurp() {
        return ctgyPurp;
    }

    /**
     * ����ctgyPurp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryPurpose1 }
     *     
     */
    public void setCtgyPurp(CategoryPurpose1 value) {
        this.ctgyPurp = value;
    }

}
