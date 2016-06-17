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
 * <p>CustomerCreditTransferInformation1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CustomerCreditTransferInformation1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TxId" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max16NumericText"/>
 *         &lt;element name="Dbtr" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Debtor1"/>
 *         &lt;element name="DbtrAcct" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}DebtorAccount1"/>
 *         &lt;element name="DbtrAgt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}DebtorAgent1"/>
 *         &lt;element name="CdtrAgt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}CreditorAgent1"/>
 *         &lt;element name="Cdtr" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Creditor1"/>
 *         &lt;element name="CdtrAcct" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}CreditorAccount1"/>
 *         &lt;element name="Amt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ActiveCurrencyAndAmount"/>
 *         &lt;element name="PmtTpInf" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}PaymentTypeInformation1"/>
 *         &lt;element name="Purp" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Purpose1"/>
 *         &lt;element name="AddtlInf" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max256Text" minOccurs="0"/>
 *         &lt;element name="CstmrCdtTrfAddtlInf" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}CustomerCreditTransferAdditionalInformation1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerCreditTransferInformation1", propOrder = {
    "txId",
    "dbtr",
    "dbtrAcct",
    "dbtrAgt",
    "cdtrAgt",
    "cdtr",
    "cdtrAcct",
    "amt",
    "pmtTpInf",
    "purp",
    "addtlInf",
    "cstmrCdtTrfAddtlInf"
})
public class CustomerCreditTransferInformation1 {

    @XmlElement(name = "TxId", required = true)
    protected String txId;
    @XmlElement(name = "Dbtr", required = true)
    protected Debtor1 dbtr;
    @XmlElement(name = "DbtrAcct", required = true)
    protected DebtorAccount1 dbtrAcct;
    @XmlElement(name = "DbtrAgt", required = true)
    protected DebtorAgent1 dbtrAgt;
    @XmlElement(name = "CdtrAgt", required = true)
    protected CreditorAgent1 cdtrAgt;
    @XmlElement(name = "Cdtr", required = true)
    protected Creditor1 cdtr;
    @XmlElement(name = "CdtrAcct", required = true)
    protected CreditorAccount1 cdtrAcct;
    @XmlElement(name = "Amt", required = true)
    protected ActiveCurrencyAndAmount amt;
    @XmlElement(name = "PmtTpInf", required = true)
    protected PaymentTypeInformation1 pmtTpInf;
    @XmlElement(name = "Purp", required = true)
    protected Purpose1 purp;
    @XmlElement(name = "AddtlInf")
    protected String addtlInf;
    @XmlElement(name = "CstmrCdtTrfAddtlInf")
    protected CustomerCreditTransferAdditionalInformation1 cstmrCdtTrfAddtlInf;

    /**
     * 获取txId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxId() {
        return txId;
    }

    /**
     * 设置txId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxId(String value) {
        this.txId = value;
    }

    /**
     * 获取dbtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Debtor1 }
     *     
     */
    public Debtor1 getDbtr() {
        return dbtr;
    }

    /**
     * 设置dbtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Debtor1 }
     *     
     */
    public void setDbtr(Debtor1 value) {
        this.dbtr = value;
    }

    /**
     * 获取dbtrAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DebtorAccount1 }
     *     
     */
    public DebtorAccount1 getDbtrAcct() {
        return dbtrAcct;
    }

    /**
     * 设置dbtrAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DebtorAccount1 }
     *     
     */
    public void setDbtrAcct(DebtorAccount1 value) {
        this.dbtrAcct = value;
    }

    /**
     * 获取dbtrAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DebtorAgent1 }
     *     
     */
    public DebtorAgent1 getDbtrAgt() {
        return dbtrAgt;
    }

    /**
     * 设置dbtrAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DebtorAgent1 }
     *     
     */
    public void setDbtrAgt(DebtorAgent1 value) {
        this.dbtrAgt = value;
    }

    /**
     * 获取cdtrAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditorAgent1 }
     *     
     */
    public CreditorAgent1 getCdtrAgt() {
        return cdtrAgt;
    }

    /**
     * 设置cdtrAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditorAgent1 }
     *     
     */
    public void setCdtrAgt(CreditorAgent1 value) {
        this.cdtrAgt = value;
    }

    /**
     * 获取cdtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Creditor1 }
     *     
     */
    public Creditor1 getCdtr() {
        return cdtr;
    }

    /**
     * 设置cdtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Creditor1 }
     *     
     */
    public void setCdtr(Creditor1 value) {
        this.cdtr = value;
    }

    /**
     * 获取cdtrAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditorAccount1 }
     *     
     */
    public CreditorAccount1 getCdtrAcct() {
        return cdtrAcct;
    }

    /**
     * 设置cdtrAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditorAccount1 }
     *     
     */
    public void setCdtrAcct(CreditorAccount1 value) {
        this.cdtrAcct = value;
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
     * 获取pmtTpInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentTypeInformation1 }
     *     
     */
    public PaymentTypeInformation1 getPmtTpInf() {
        return pmtTpInf;
    }

    /**
     * 设置pmtTpInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTypeInformation1 }
     *     
     */
    public void setPmtTpInf(PaymentTypeInformation1 value) {
        this.pmtTpInf = value;
    }

    /**
     * 获取purp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Purpose1 }
     *     
     */
    public Purpose1 getPurp() {
        return purp;
    }

    /**
     * 设置purp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Purpose1 }
     *     
     */
    public void setPurp(Purpose1 value) {
        this.purp = value;
    }

    /**
     * 获取addtlInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddtlInf() {
        return addtlInf;
    }

    /**
     * 设置addtlInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddtlInf(String value) {
        this.addtlInf = value;
    }

    /**
     * 获取cstmrCdtTrfAddtlInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CustomerCreditTransferAdditionalInformation1 }
     *     
     */
    public CustomerCreditTransferAdditionalInformation1 getCstmrCdtTrfAddtlInf() {
        return cstmrCdtTrfAddtlInf;
    }

    /**
     * 设置cstmrCdtTrfAddtlInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerCreditTransferAdditionalInformation1 }
     *     
     */
    public void setCstmrCdtTrfAddtlInf(CustomerCreditTransferAdditionalInformation1 value) {
        this.cstmrCdtTrfAddtlInf = value;
    }

}
