package com.legend.common.core.databus;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.legend.common.core.config.config;
import com.legend.common.core.databus.DataBus;
import com.legend.common.core.databus.DataBusConverter;
import com.legend.common.core.exception.DataBusLoadException;
import com.legend.common.core.exception.DataConvLoadException;
import com.legend.common.core.exception.DatabusConvException;


public class DataBusConverterTest {

	@Test
	public void testDataBusConverter() throws DataBusLoadException, DataConvLoadException, DatabusConvException {
		DataBusConverter dataBusConverter = new DataBusConverter(config.TPS_CONFIG+"DataDicMap.xml",config.TPS_CONFIG);
		Map<String,Object> src = new HashMap<String,Object>();
		String source = "123";
		src.put("cartoon.message.id", source);
		DataBus dataBus = new DataBus();
		dataBusConverter.toDataBus("CPReq_I", src,dataBus);
		System.out.println(dataBus);
		Map<String,Object> des = new HashMap<String,Object>();
		dataBusConverter.toMap("CPReq_O", dataBus,des);
		String destination = (String) des.get("/Cartoon/CpReq/id/dd");
		System.out.println((String) des.get("/Cartoon/CpReq/id/Code"));
		Assert.assertEquals(source, destination);
	}

}
