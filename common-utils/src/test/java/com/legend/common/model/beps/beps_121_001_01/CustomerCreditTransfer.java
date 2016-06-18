//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2016.06.17 ʱ�� 03:58:59 PM CST 
//


package com.legend.common.model.beps.beps_121_001_01;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CustomerCreditTransfer complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CustomerCreditTransfer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PKGGrpHdr" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}PKGGroupHeader1"/>
 *         &lt;element name="NPCPrcInf" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}NPCProcessInformation1" minOccurs="0"/>
 *         &lt;element name="CstmrCdtTrfInf" type="{urn:cnaps:std:beps:2010:tech:xsd:beps.121.001.01}CustomerCreditTransferInformation1" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerCreditTransfer", propOrder = {
    "pkgGrpHdr",
    "npcPrcInf",
    "cstmrCdtTrfInf"
})
public class CustomerCreditTransfer {

    @XmlElement(name = "PKGGrpHdr", required = true)
    protected PKGGroupHeader1 pkgGrpHdr;
    @XmlElement(name = "NPCPrcInf")
    protected NPCProcessInformation1 npcPrcInf;
    @XmlElement(name = "CstmrCdtTrfInf", required = true)
    protected List<CustomerCreditTransferInformation1> cstmrCdtTrfInf;

    /**
     * ��ȡpkgGrpHdr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PKGGroupHeader1 }
     *     
     */
    public PKGGroupHeader1 getPKGGrpHdr() {
        return pkgGrpHdr;
    }

    /**
     * ����pkgGrpHdr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PKGGroupHeader1 }
     *     
     */
    public void setPKGGrpHdr(PKGGroupHeader1 value) {
        this.pkgGrpHdr = value;
    }

    /**
     * ��ȡnpcPrcInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link NPCProcessInformation1 }
     *     
     */
    public NPCProcessInformation1 getNPCPrcInf() {
        return npcPrcInf;
    }

    /**
     * ����npcPrcInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link NPCProcessInformation1 }
     *     
     */
    public void setNPCPrcInf(NPCProcessInformation1 value) {
        this.npcPrcInf = value;
    }

    /**
     * Gets the value of the cstmrCdtTrfInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cstmrCdtTrfInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCstmrCdtTrfInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerCreditTransferInformation1 }
     * 
     * 
     */
    public List<CustomerCreditTransferInformation1> getCstmrCdtTrfInf() {
        if (cstmrCdtTrfInf == null) {
            cstmrCdtTrfInf = new ArrayList<CustomerCreditTransferInformation1>();
        }
        return this.cstmrCdtTrfInf;
    }

}
