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
 * <p>OriginalTransaction1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="OriginalTransaction1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InstgIndrctPty" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max14Text"/>
 *         &lt;element name="InstdIndrctPty" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max14Text"/>
 *         &lt;element name="OrgnlTxId" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max16NumericText"/>
 *         &lt;element name="OrgnlTxTpCd" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max4Text"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalTransaction1", propOrder = {
    "instgIndrctPty",
    "instdIndrctPty",
    "orgnlTxId",
    "orgnlTxTpCd"
})
public class OriginalTransaction1 {

    @XmlElement(name = "InstgIndrctPty", required = true)
    protected String instgIndrctPty;
    @XmlElement(name = "InstdIndrctPty", required = true)
    protected String instdIndrctPty;
    @XmlElement(name = "OrgnlTxId", required = true)
    protected String orgnlTxId;
    @XmlElement(name = "OrgnlTxTpCd", required = true)
    protected String orgnlTxTpCd;

    /**
     * ��ȡinstgIndrctPty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstgIndrctPty() {
        return instgIndrctPty;
    }

    /**
     * ����instgIndrctPty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstgIndrctPty(String value) {
        this.instgIndrctPty = value;
    }

    /**
     * ��ȡinstdIndrctPty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstdIndrctPty() {
        return instdIndrctPty;
    }

    /**
     * ����instdIndrctPty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstdIndrctPty(String value) {
        this.instdIndrctPty = value;
    }

    /**
     * ��ȡorgnlTxId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlTxId() {
        return orgnlTxId;
    }

    /**
     * ����orgnlTxId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlTxId(String value) {
        this.orgnlTxId = value;
    }

    /**
     * ��ȡorgnlTxTpCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlTxTpCd() {
        return orgnlTxTpCd;
    }

    /**
     * ����orgnlTxTpCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlTxTpCd(String value) {
        this.orgnlTxTpCd = value;
    }

}
