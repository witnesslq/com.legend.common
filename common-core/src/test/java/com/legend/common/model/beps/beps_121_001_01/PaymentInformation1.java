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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PaymentInformation1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PaymentInformation1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FlowNb" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max20Text"/>
 *         &lt;element name="Term" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max16NumericText"/>
 *         &lt;element name="Tp" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}Max4Text"/>
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
@XmlType(name = "PaymentInformation1", propOrder = {
    "flowNb",
    "term",
    "tp",
    "rmk"
})
public class PaymentInformation1 {

    @XmlElement(name = "FlowNb", required = true)
    protected String flowNb;
    @XmlElement(name = "Term", required = true)
    protected String term;
    @XmlElement(name = "Tp", required = true)
    protected String tp;
    @XmlElement(name = "Rmk")
    protected String rmk;

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
     * ��ȡterm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerm() {
        return term;
    }

    /**
     * ����term���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerm(String value) {
        this.term = value;
    }

    /**
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTp(String value) {
        this.tp = value;
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
