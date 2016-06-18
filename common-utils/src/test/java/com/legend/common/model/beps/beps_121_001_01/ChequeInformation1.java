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
 * <p>ChequeInformation1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ChequeInformation1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IsseDt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ISODate"/>
 *         &lt;element name="DrwrNm" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max60Text"/>
 *         &lt;element name="ChqAmt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ActiveCurrencyAndAmount"/>
 *         &lt;element name="Amt" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ActiveCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="Nb" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max4NumericText"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChequeInformation1", propOrder = {
    "isseDt",
    "drwrNm",
    "chqAmt",
    "amt",
    "nb"
})
public class ChequeInformation1 {

    @XmlElement(name = "IsseDt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar isseDt;
    @XmlElement(name = "DrwrNm", required = true)
    protected String drwrNm;
    @XmlElement(name = "ChqAmt", required = true)
    protected ActiveCurrencyAndAmount chqAmt;
    @XmlElement(name = "Amt")
    protected ActiveCurrencyAndAmount amt;
    @XmlElement(name = "Nb", required = true)
    protected String nb;

    /**
     * ��ȡisseDt���Ե�ֵ��
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
     * ����isseDt���Ե�ֵ��
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
     * ��ȡdrwrNm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrwrNm() {
        return drwrNm;
    }

    /**
     * ����drwrNm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrwrNm(String value) {
        this.drwrNm = value;
    }

    /**
     * ��ȡchqAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public ActiveCurrencyAndAmount getChqAmt() {
        return chqAmt;
    }

    /**
     * ����chqAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public void setChqAmt(ActiveCurrencyAndAmount value) {
        this.chqAmt = value;
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
     * ��ȡnb���Ե�ֵ��
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
     * ����nb���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNb(String value) {
        this.nb = value;
    }

}
