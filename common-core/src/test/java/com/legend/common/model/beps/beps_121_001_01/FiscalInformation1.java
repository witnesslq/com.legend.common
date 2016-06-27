//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2016.06.17 ʱ�� 03:58:59 PM CST 
//


package com.legend.common.model.beps.beps_121_001_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>FiscalInformation1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡflowNb���Ե�ֵ��
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
     * ����flowNb���Ե�ֵ��
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
     * ��ȡamt���Ե�ֵ��
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
     * ����amt���Ե�ֵ��
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
     * ��ȡrptCd���Ե�ֵ��
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
     * ����rptCd���Ե�ֵ��
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
     * ��ȡrcvCd���Ե�ֵ��
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
     * ����rcvCd���Ե�ֵ��
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
     * ��ȡrptFrms���Ե�ֵ��
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
     * ����rptFrms���Ե�ֵ��
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
     * ��ȡrptNb���Ե�ֵ��
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
     * ����rptNb���Ե�ֵ��
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
