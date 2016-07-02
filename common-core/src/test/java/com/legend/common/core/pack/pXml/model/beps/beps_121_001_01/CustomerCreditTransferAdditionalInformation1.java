//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2016.06.17 ʱ�� 03:58:59 PM CST 
//


package com.legend.common.core.pack.pXml.model.beps.beps_121_001_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CustomerCreditTransferAdditionalInformation1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡcolltnInf���Ե�ֵ��
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
     * ����colltnInf���Ե�ֵ��
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
     * ��ȡcolltnWthAccptncInf���Ե�ֵ��
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
     * ����colltnWthAccptncInf���Ե�ֵ��
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
     * ��ȡpmtInf���Ե�ֵ��
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
     * ����pmtInf���Ե�ֵ��
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
     * ��ȡrtrInf���Ե�ֵ��
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
     * ����rtrInf���Ե�ֵ��
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
     * ��ȡchqInf���Ե�ֵ��
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
     * ����chqInf���Ե�ֵ��
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
     * ��ȡbkDrftInf���Ե�ֵ��
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
     * ����bkDrftInf���Ե�ֵ��
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
     * ��ȡcomrclDrftInf���Ե�ֵ��
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
     * ����comrclDrftInf���Ե�ֵ��
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
     * ��ȡcshrChckInf���Ե�ֵ��
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
     * ����cshrChckInf���Ե�ֵ��
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
