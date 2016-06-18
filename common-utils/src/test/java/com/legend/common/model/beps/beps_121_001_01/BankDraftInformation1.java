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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>BankDraftInformation1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="BankDraftInformation1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IsseDt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ISODate"/>
 *         &lt;element name="DrftAmt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}AmountText"/>
 *         &lt;element name="ApplyAcct" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max32Text" minOccurs="0"/>
 *         &lt;element name="ApplyNm" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max60Text" minOccurs="0"/>
 *         &lt;element name="SttlmAmt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}AmountText" minOccurs="0"/>
 *         &lt;element name="OddAmt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}AmountText" minOccurs="0"/>
 *         &lt;element name="DrftTp" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max4Text"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankDraftInformation1", propOrder = {
    "isseDt",
    "drftAmt",
    "applyAcct",
    "applyNm",
    "sttlmAmt",
    "oddAmt",
    "drftTp"
})
public class BankDraftInformation1 {

    @XmlElement(name = "IsseDt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar isseDt;
    @XmlElement(name = "DrftAmt", required = true)
    protected String drftAmt;
    @XmlElement(name = "ApplyAcct")
    protected String applyAcct;
    @XmlElement(name = "ApplyNm")
    protected String applyNm;
    @XmlElement(name = "SttlmAmt")
    protected String sttlmAmt;
    @XmlElement(name = "OddAmt")
    protected String oddAmt;
    @XmlElement(name = "DrftTp", required = true)
    protected String drftTp;

    /**
     * ��ȡisseDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIsseDt() {
        return isseDt;
    }

    /**
     * ����isseDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIsseDt(XMLGregorianCalendar value) {
        this.isseDt = value;
    }

    /**
     * ��ȡdrftAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrftAmt() {
        return drftAmt;
    }

    /**
     * ����drftAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrftAmt(String value) {
        this.drftAmt = value;
    }

    /**
     * ��ȡapplyAcct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyAcct() {
        return applyAcct;
    }

    /**
     * ����applyAcct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyAcct(String value) {
        this.applyAcct = value;
    }

    /**
     * ��ȡapplyNm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyNm() {
        return applyNm;
    }

    /**
     * ����applyNm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyNm(String value) {
        this.applyNm = value;
    }

    /**
     * ��ȡsttlmAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSttlmAmt() {
        return sttlmAmt;
    }

    /**
     * ����sttlmAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSttlmAmt(String value) {
        this.sttlmAmt = value;
    }

    /**
     * ��ȡoddAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddAmt() {
        return oddAmt;
    }

    /**
     * ����oddAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddAmt(String value) {
        this.oddAmt = value;
    }

    /**
     * ��ȡdrftTp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrftTp() {
        return drftTp;
    }

    /**
     * ����drftTp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrftTp(String value) {
        this.drftTp = value;
    }

}
