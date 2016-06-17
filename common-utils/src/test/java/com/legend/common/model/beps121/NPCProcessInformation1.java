//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2016.06.17 时间 03:58:59 PM CST 
//


package com.legend.common.model.beps121;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>NPCProcessInformation1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取prcSts属性的值。
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
     * 设置prcSts属性的值。
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
     * 获取prcCd属性的值。
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
     * 设置prcCd属性的值。
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
     * 获取rjctInf属性的值。
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
     * 设置rjctInf属性的值。
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
     * 获取netgDt属性的值。
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
     * 设置netgDt属性的值。
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
     * 获取netgRnd属性的值。
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
     * 设置netgRnd属性的值。
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
     * 获取sttlmDt属性的值。
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
     * 设置sttlmDt属性的值。
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
     * 获取rcvTm属性的值。
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
     * 设置rcvTm属性的值。
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
     * 获取trnsmtTm属性的值。
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
     * 设置trnsmtTm属性的值。
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
