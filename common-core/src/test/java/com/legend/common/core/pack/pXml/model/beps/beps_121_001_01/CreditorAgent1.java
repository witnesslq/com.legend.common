//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2016.06.17 ʱ�� 03:58:59 PM CST 
//


package com.legend.common.core.pack.pXml.model.beps.beps_121_001_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CreditorAgent1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CreditorAgent1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BrnchId" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}BranchIdentification1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditorAgent1", propOrder = {
    "brnchId"
})
public class CreditorAgent1 {

    @XmlElement(name = "BrnchId", required = true)
    protected BranchIdentification1 brnchId;

    /**
     * ��ȡbrnchId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchIdentification1 }
     *     
     */
    public BranchIdentification1 getBrnchId() {
        return brnchId;
    }

    /**
     * ����brnchId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchIdentification1 }
     *     
     */
    public void setBrnchId(BranchIdentification1 value) {
        this.brnchId = value;
    }

}
