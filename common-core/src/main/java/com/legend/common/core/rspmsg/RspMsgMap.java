package com.legend.common.core.rspmsg;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rspMsg"
})
@XmlRootElement(name = "RspMsgMap")
public class RspMsgMap {

    @XmlElement(name = "RspMsg", required = true)
    protected List<RspMsg> rspMsg;

    public List<RspMsg> getRspMsg() {
        if (rspMsg == null) {
            rspMsg = new ArrayList<RspMsg>();
        }
        return this.rspMsg;
    }

}
