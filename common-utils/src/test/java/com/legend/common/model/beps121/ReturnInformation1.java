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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ReturnInformation1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取orgnlGrpHdr属性的值。
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
     * 设置orgnlGrpHdr属性的值。
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
     * 获取orgnlTx属性的值。
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
     * 设置orgnlTx属性的值。
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
     * 获取cntt属性的值。
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
     * 设置cntt属性的值。
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
