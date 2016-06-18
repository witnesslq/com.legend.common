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
 * <p>ReturnInformation1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ReturnInformation1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgnlGrpHdr" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}OriginalGroupHeader1"/>
 *         &lt;element name="OrgnlTx" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}OriginalTransaction1"/>
 *         &lt;element name="Cntt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max256Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnInformation1", propOrder = {
    "orgnlGrpHdr",
    "orgnlTx",
    "cntt"
})
public class ReturnInformation1 {

    @XmlElement(name = "OrgnlGrpHdr", required = true)
    protected OriginalGroupHeader1 orgnlGrpHdr;
    @XmlElement(name = "OrgnlTx", required = true)
    protected OriginalTransaction1 orgnlTx;
    @XmlElement(name = "Cntt")
    protected String cntt;

    /**
     * ��ȡorgnlGrpHdr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OriginalGroupHeader1 }
     *     
     */
    public OriginalGroupHeader1 getOrgnlGrpHdr() {
        return orgnlGrpHdr;
    }

    /**
     * ����orgnlGrpHdr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalGroupHeader1 }
     *     
     */
    public void setOrgnlGrpHdr(OriginalGroupHeader1 value) {
        this.orgnlGrpHdr = value;
    }

    /**
     * ��ȡorgnlTx���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OriginalTransaction1 }
     *     
     */
    public OriginalTransaction1 getOrgnlTx() {
        return orgnlTx;
    }

    /**
     * ����orgnlTx���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalTransaction1 }
     *     
     */
    public void setOrgnlTx(OriginalTransaction1 value) {
        this.orgnlTx = value;
    }

    /**
     * ��ȡcntt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCntt() {
        return cntt;
    }

    /**
     * ����cntt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCntt(String value) {
        this.cntt = value;
    }

}
