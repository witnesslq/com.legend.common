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
 * <p>PaymentTypeInformation1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentTypeInformation1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CtgyPurp" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}CategoryPurpose1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTypeInformation1", propOrder = {
    "ctgyPurp"
})
public class PaymentTypeInformation1 {

    @XmlElement(name = "CtgyPurp", required = true)
    protected CategoryPurpose1 ctgyPurp;

    /**
     * 获取ctgyPurp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CategoryPurpose1 }
     *     
     */
    public CategoryPurpose1 getCtgyPurp() {
        return ctgyPurp;
    }

    /**
     * 设置ctgyPurp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryPurpose1 }
     *     
     */
    public void setCtgyPurp(CategoryPurpose1 value) {
        this.ctgyPurp = value;
    }

}
