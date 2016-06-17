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
 * <p>FiscalInformation1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="FiscalInformation1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FlowNb" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max20Text"/>
 *         &lt;element name="Amt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ActiveCurrencyAndAmount"/>
 *         &lt;element name="RptCd" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max10NumericText"/>
 *         &lt;element name="RcvCd" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max10NumericText"/>
 *         &lt;element name="RptFrms" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ISODate"/>
 *         &lt;element name="RptNb" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max10NumericText"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FiscalInformation1", propOrder = {
    "flowNb",
    "amt",
    "rptCd",
    "rcvCd",
    "rptFrms",
    "rptNb"
})
public class FiscalInformation1 {

    @XmlElement(name = "FlowNb", required = true)
    protected String flowNb;
    @XmlElement(name = "Amt", required = true)
    protected ActiveCurrencyAndAmount amt;
    @XmlElement(name = "RptCd", required = true)
    protected String rptCd;
    @XmlElement(name = "RcvCd", required = true)
    protected String rcvCd;
    @XmlElement(name = "RptFrms", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar rptFrms;
    @XmlElement(name = "RptNb", required = true)
    protected String rptNb;

    /**
     * 获取flowNb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlowNb() {
        return flowNb;
    }

    /**
     * 设置flowNb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlowNb(String value) {
        this.flowNb = value;
    }

    /**
     * 获取amt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public ActiveCurrencyAndAmount getAmt() {
        return amt;
    }

    /**
     * 设置amt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public void setAmt(ActiveCurrencyAndAmount value) {
        this.amt = value;
    }

    /**
     * 获取rptCd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRptCd() {
        return rptCd;
    }

    /**
     * 设置rptCd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRptCd(String value) {
        this.rptCd = value;
    }

    /**
     * 获取rcvCd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRcvCd() {
        return rcvCd;
    }

    /**
     * 设置rcvCd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRcvCd(String value) {
        this.rcvCd = value;
    }

    /**
     * 获取rptFrms属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRptFrms() {
        return rptFrms;
    }

    /**
     * 设置rptFrms属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRptFrms(XMLGregorianCalendar value) {
        this.rptFrms = value;
    }

    /**
     * 获取rptNb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRptNb() {
        return rptNb;
    }

    /**
     * 设置rptNb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRptNb(String value) {
        this.rptNb = value;
    }

}
