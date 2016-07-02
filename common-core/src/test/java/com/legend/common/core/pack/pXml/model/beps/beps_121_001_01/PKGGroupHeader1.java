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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>PKGGroupHeader1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PKGGroupHeader1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgId" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max35Text"/>
 *         &lt;element name="CreDtTm" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ISODateTime"/>
 *         &lt;element name="InstgPty" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}InstgPty1"/>
 *         &lt;element name="InstdPty" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}InstdPty1"/>
 *         &lt;element name="NbOfTxs" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max15NumericText"/>
 *         &lt;element name="CtrlSum" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}ActiveCurrencyAndAmount"/>
 *         &lt;element name="SysCd" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}SystemCode1"/>
 *         &lt;element name="Rmk" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max256Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PKGGroupHeader1", propOrder = {
    "msgId",
    "creDtTm",
    "instgPty",
    "instdPty",
    "nbOfTxs",
    "ctrlSum",
    "sysCd",
    "rmk"
})
public class PKGGroupHeader1 {

    @XmlElement(name = "MsgId", required = true)
    protected String msgId;
    @XmlElement(name = "CreDtTm", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creDtTm;
    @XmlElement(name = "InstgPty", required = true)
    protected InstgPty1 instgPty;
    @XmlElement(name = "InstdPty", required = true)
    protected InstdPty1 instdPty;
    @XmlElement(name = "NbOfTxs", required = true)
    protected String nbOfTxs;
    @XmlElement(name = "CtrlSum", required = true)
    protected ActiveCurrencyAndAmount ctrlSum;
    @XmlElement(name = "SysCd", required = true)
    @XmlSchemaType(name = "string")
    protected SystemCode1 sysCd;
    @XmlElement(name = "Rmk")
    protected String rmk;

    /**
     * ��ȡmsgId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * ����msgId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgId(String value) {
        this.msgId = value;
    }

    /**
     * ��ȡcreDtTm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreDtTm() {
        return creDtTm;
    }

    /**
     * ����creDtTm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreDtTm(XMLGregorianCalendar value) {
        this.creDtTm = value;
    }

    /**
     * ��ȡinstgPty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link InstgPty1 }
     *     
     */
    public InstgPty1 getInstgPty() {
        return instgPty;
    }

    /**
     * ����instgPty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link InstgPty1 }
     *     
     */
    public void setInstgPty(InstgPty1 value) {
        this.instgPty = value;
    }

    /**
     * ��ȡinstdPty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link InstdPty1 }
     *     
     */
    public InstdPty1 getInstdPty() {
        return instdPty;
    }

    /**
     * ����instdPty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link InstdPty1 }
     *     
     */
    public void setInstdPty(InstdPty1 value) {
        this.instdPty = value;
    }

    /**
     * ��ȡnbOfTxs���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbOfTxs() {
        return nbOfTxs;
    }

    /**
     * ����nbOfTxs���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbOfTxs(String value) {
        this.nbOfTxs = value;
    }

    /**
     * ��ȡctrlSum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public ActiveCurrencyAndAmount getCtrlSum() {
        return ctrlSum;
    }

    /**
     * ����ctrlSum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public void setCtrlSum(ActiveCurrencyAndAmount value) {
        this.ctrlSum = value;
    }

    /**
     * ��ȡsysCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SystemCode1 }
     *     
     */
    public SystemCode1 getSysCd() {
        return sysCd;
    }

    /**
     * ����sysCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SystemCode1 }
     *     
     */
    public void setSysCd(SystemCode1 value) {
        this.sysCd = value;
    }

    /**
     * ��ȡrmk���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmk() {
        return rmk;
    }

    /**
     * ����rmk���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmk(String value) {
        this.rmk = value;
    }

}
