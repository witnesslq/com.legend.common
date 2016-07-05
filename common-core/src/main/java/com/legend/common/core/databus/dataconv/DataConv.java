package com.legend.common.core.databus.dataconv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "source",
    "destination"
})
public class DataConv {

    @XmlElement(name = "Source", required = true)
    protected DataConv.Source source;
    @XmlElement(name = "Destination", required = true)
    protected String destination;


    public DataConv.Source getSource() {
        return source;
    }


    public void setSource(DataConv.Source value) {
        this.source = value;
    }


    public String getDestination() {
        return destination;
    }


    public void setDestination(String value) {
        this.destination = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Source {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "type")
        protected String type;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            if (type == null) {
                return "databus";
            } else {
                return type;
            }
        }

        public void setType(String value) {
            this.type = value;
        }

    }

}
