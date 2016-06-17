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
 * <p>CollectionWithAcceptanceInformation1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CollectionWithAcceptanceInformation1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Dt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ISODate"/>
 *         &lt;element name="Nb" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max32Text"/>
 *         &lt;element name="AmdsAmt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ActiveCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="RctAmt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ActiveCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="OrgnlAmt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ActiveCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="PmtAmt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ActiveCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="OddAmt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ActiveCurrencyAndAmount" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CollectionWithAcceptanceInformation1", propOrder = {
    "dt",
    "nb",
    "amdsAmt",
    "rctAmt",
    "orgnlAmt",
    "pmtAmt",
    "oddAmt"
})
public class CollectionWithAcceptanceInformation1 {

    @XmlElement(name = "Dt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dt;
    @XmlElement(name = "Nb", required = true)
    protected String nb;
    @XmlElement(name = "AmdsAmt")
    protected ActiveCurrencyAndAmount amdsAmt;
    @XmlElement(name = "RctAmt")
    protected ActiveCurrencyAndAmount rctAmt;
    @XmlElement(name = "OrgnlAmt")
    protected ActiveCurrencyAndAmount orgnlAmt;
    @XmlElement(name = "PmtAmt")
    protected ActiveCurrencyAndAmount pmtAmt;
    @XmlElement(name = "OddAmt")
    protected ActiveCurrencyAndAmount oddAmt;

    /**
     * 获取dt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDt() {
        return dt;
    }

    /**
     * 设置dt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDt(XMLGregorianCalendar value) {
        this.dt = value;
    }

    /**
     * 获取nb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNb() {
        return nb;
    }

    /**
     * 设置nb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNb(String value) {
        this.nb = value;
    }

    /**
     * 获取amdsAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public ActiveCurrencyAndAmount getAmdsAmt() {
        return amdsAmt;
    }

    /**
     * 设置amdsAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public void setAmdsAmt(ActiveCurrencyAndAmount value) {
        this.amdsAmt = value;
    }

    /**
     * 获取rctAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public ActiveCurrencyAndAmount getRctAmt() {
        return rctAmt;
    }

    /**
     * 设置rctAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public void setRctAmt(ActiveCurrencyAndAmount value) {
        this.rctAmt = value;
    }

    /**
     * 获取orgnlAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public ActiveCurrencyAndAmount getOrgnlAmt() {
        return orgnlAmt;
    }

    /**
     * 设置orgnlAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public void setOrgnlAmt(ActiveCurrencyAndAmount value) {
        this.orgnlAmt = value;
    }

    /**
     * 获取pmtAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public ActiveCurrencyAndAmount getPmtAmt() {
        return pmtAmt;
    }

    /**
     * 设置pmtAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public void setPmtAmt(ActiveCurrencyAndAmount value) {
        this.pmtAmt = value;
    }

    /**
     * 获取oddAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public ActiveCurrencyAndAmount getOddAmt() {
        return oddAmt;
    }

    /**
     * 设置oddAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public void setOddAmt(ActiveCurrencyAndAmount value) {
        this.oddAmt = value;
    }

}
