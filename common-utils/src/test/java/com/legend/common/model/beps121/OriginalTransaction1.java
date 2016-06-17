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
 * <p>OriginalTransaction1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取instgIndrctPty属性的值。
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
     * 设置instgIndrctPty属性的值。
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
     * 获取instdIndrctPty属性的值。
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
     * 设置instdIndrctPty属性的值。
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
     * 获取orgnlTxId属性的值。
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
     * 设置orgnlTxId属性的值。
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
     * 获取orgnlTxTpCd属性的值。
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
     * 设置orgnlTxTpCd属性的值。
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
