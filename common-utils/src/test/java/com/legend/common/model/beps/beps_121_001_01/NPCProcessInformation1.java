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
 * <p>NPCProcessInformation1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="NPCProcessInformation1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PrcSts" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max4Text"/>
 *         &lt;element name="PrcCd" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max8Text"/>
 *         &lt;element name="RjctInf" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max105Text" minOccurs="0"/>
 *         &lt;element name="NetgDt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ISODate" minOccurs="0"/>
 *         &lt;element name="NetgRnd" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max2NumericText" minOccurs="0"/>
 *         &lt;element name="SttlmDt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ISODate" minOccurs="0"/>
 *         &lt;element name="RcvTm" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ISODateTime" minOccurs="0"/>
 *         &lt;element name="TrnsmtTm" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ISODateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NPCProcessInformation1", propOrder = {
    "prcSts",
    "prcCd",
    "rjctInf",
    "netgDt",
    "netgRnd",
    "sttlmDt",
    "rcvTm",
    "trnsmtTm"
})
public class NPCProcessInformation1 {

    @XmlElement(name = "PrcSts", required = true)
    protected String prcSts;
    @XmlElement(name = "PrcCd", required = true)
    protected String prcCd;
    @XmlElement(name = "RjctInf")
    protected String rjctInf;
    @XmlElement(name = "NetgDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar netgDt;
    @XmlElement(name = "NetgRnd")
    protected String netgRnd;
    @XmlElement(name = "SttlmDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar sttlmDt;
    @XmlElement(name = "RcvTm")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rcvTm;
    @XmlElement(name = "TrnsmtTm")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar trnsmtTm;

    /**
     * ��ȡprcSts���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrcSts() {
        return prcSts;
    }

    /**
     * ����prcSts���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrcSts(String value) {
        this.prcSts = value;
    }

    /**
     * ��ȡprcCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrcCd() {
        return prcCd;
    }

    /**
     * ����prcCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrcCd(String value) {
        this.prcCd = value;
    }

    /**
     * ��ȡrjctInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRjctInf() {
        return rjctInf;
    }

    /**
     * ����rjctInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRjctInf(String value) {
        this.rjctInf = value;
    }

    /**
     * ��ȡnetgDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNetgDt() {
        return netgDt;
    }

    /**
     * ����netgDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNetgDt(XMLGregorianCalendar value) {
        this.netgDt = value;
    }

    /**
     * ��ȡnetgRnd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetgRnd() {
        return netgRnd;
    }

    /**
     * ����netgRnd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetgRnd(String value) {
        this.netgRnd = value;
    }

    /**
     * ��ȡsttlmDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSttlmDt() {
        return sttlmDt;
    }

    /**
     * ����sttlmDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSttlmDt(XMLGregorianCalendar value) {
        this.sttlmDt = value;
    }

    /**
     * ��ȡrcvTm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRcvTm() {
        return rcvTm;
    }

    /**
     * ����rcvTm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRcvTm(XMLGregorianCalendar value) {
        this.rcvTm = value;
    }

    /**
     * ��ȡtrnsmtTm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTrnsmtTm() {
        return trnsmtTm;
    }

    /**
     * ����trnsmtTm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTrnsmtTm(XMLGregorianCalendar value) {
        this.trnsmtTm = value;
    }

}
