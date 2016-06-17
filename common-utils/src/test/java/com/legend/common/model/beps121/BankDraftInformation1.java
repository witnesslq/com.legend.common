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
 * <p>BankDraftInformation1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取isseDt属性的值。
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
     * 设置isseDt属性的值。
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
     * 获取drftAmt属性的值。
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
     * 设置drftAmt属性的值。
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
     * 获取applyAcct属性的值。
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
     * 设置applyAcct属性的值。
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
     * 获取applyNm属性的值。
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
     * 设置applyNm属性的值。
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
     * 获取sttlmAmt属性的值。
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
     * 设置sttlmAmt属性的值。
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
     * 获取oddAmt属性的值。
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
     * 设置oddAmt属性的值。
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
     * 获取drftTp属性的值。
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
     * 设置drftTp属性的值。
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
