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
 * <p>CustomerCreditTransferAdditionalInformation1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CustomerCreditTransferAdditionalInformation1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element name="ColltnInf" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}CollectionInformation1"/>
 *           &lt;element name="ColltnWthAccptncInf" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}CollectionWithAcceptanceInformation1"/>
 *           &lt;element name="PmtInf" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}PaymentInformation1"/>
 *           &lt;element name="RtrInf" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ReturnInformation1"/>
 *           &lt;element name="ChqInf" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ChequeInformation1"/>
 *           &lt;element name="BkDrftInf" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}BankDraftInformation1"/>
 *           &lt;element name="ComrclDrftInf" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}CommercialDraftInformation1"/>
 *           &lt;element name="CshrChckInf" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}CashierCheckInformation1"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerCreditTransferAdditionalInformation1", propOrder = {
    "colltnInf",
    "colltnWthAccptncInf",
    "pmtInf",
    "rtrInf",
    "chqInf",
    "bkDrftInf",
    "comrclDrftInf",
    "cshrChckInf"
})
public class CustomerCreditTransferAdditionalInformation1 {

    @XmlElement(name = "ColltnInf")
    protected CollectionInformation1 colltnInf;
    @XmlElement(name = "ColltnWthAccptncInf")
    protected CollectionWithAcceptanceInformation1 colltnWthAccptncInf;
    @XmlElement(name = "PmtInf")
    protected PaymentInformation1 pmtInf;
    @XmlElement(name = "RtrInf")
    protected ReturnInformation1 rtrInf;
    @XmlElement(name = "ChqInf")
    protected ChequeInformation1 chqInf;
    @XmlElement(name = "BkDrftInf")
    protected BankDraftInformation1 bkDrftInf;
    @XmlElement(name = "ComrclDrftInf")
    protected CommercialDraftInformation1 comrclDrftInf;
    @XmlElement(name = "CshrChckInf")
    protected CashierCheckInformation1 cshrChckInf;

    /**
     * 获取colltnInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CollectionInformation1 }
     *     
     */
    public CollectionInformation1 getColltnInf() {
        return colltnInf;
    }

    /**
     * 设置colltnInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CollectionInformation1 }
     *     
     */
    public void setColltnInf(CollectionInformation1 value) {
        this.colltnInf = value;
    }

    /**
     * 获取colltnWthAccptncInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CollectionWithAcceptanceInformation1 }
     *     
     */
    public CollectionWithAcceptanceInformation1 getColltnWthAccptncInf() {
        return colltnWthAccptncInf;
    }

    /**
     * 设置colltnWthAccptncInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CollectionWithAcceptanceInformation1 }
     *     
     */
    public void setColltnWthAccptncInf(CollectionWithAcceptanceInformation1 value) {
        this.colltnWthAccptncInf = value;
    }

    /**
     * 获取pmtInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentInformation1 }
     *     
     */
    public PaymentInformation1 getPmtInf() {
        return pmtInf;
    }

    /**
     * 设置pmtInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentInformation1 }
     *     
     */
    public void setPmtInf(PaymentInformation1 value) {
        this.pmtInf = value;
    }

    /**
     * 获取rtrInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReturnInformation1 }
     *     
     */
    public ReturnInformation1 getRtrInf() {
        return rtrInf;
    }

    /**
     * 设置rtrInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnInformation1 }
     *     
     */
    public void setRtrInf(ReturnInformation1 value) {
        this.rtrInf = value;
    }

    /**
     * 获取chqInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ChequeInformation1 }
     *     
     */
    public ChequeInformation1 getChqInf() {
        return chqInf;
    }

    /**
     * 设置chqInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChequeInformation1 }
     *     
     */
    public void setChqInf(ChequeInformation1 value) {
        this.chqInf = value;
    }

    /**
     * 获取bkDrftInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BankDraftInformation1 }
     *     
     */
    public BankDraftInformation1 getBkDrftInf() {
        return bkDrftInf;
    }

    /**
     * 设置bkDrftInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BankDraftInformation1 }
     *     
     */
    public void setBkDrftInf(BankDraftInformation1 value) {
        this.bkDrftInf = value;
    }

    /**
     * 获取comrclDrftInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CommercialDraftInformation1 }
     *     
     */
    public CommercialDraftInformation1 getComrclDrftInf() {
        return comrclDrftInf;
    }

    /**
     * 设置comrclDrftInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CommercialDraftInformation1 }
     *     
     */
    public void setComrclDrftInf(CommercialDraftInformation1 value) {
        this.comrclDrftInf = value;
    }

    /**
     * 获取cshrChckInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashierCheckInformation1 }
     *     
     */
    public CashierCheckInformation1 getCshrChckInf() {
        return cshrChckInf;
    }

    /**
     * 设置cshrChckInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashierCheckInformation1 }
     *     
     */
    public void setCshrChckInf(CashierCheckInformation1 value) {
        this.cshrChckInf = value;
    }

}
