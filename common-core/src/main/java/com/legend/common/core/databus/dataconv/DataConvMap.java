
package com.legend.common.core.databus.dataconv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "dataConv" })
@XmlRootElement(name = "DataConvMap")
public class DataConvMap {

	@XmlElement(name = "DataConv", required = true)
	protected List<DataConv> dataConv;

	public List<DataConv> getDataConv() {
		if (dataConv == null) {
			dataConv = new ArrayList<DataConv>();
		}
		return this.dataConv;
	}

}
