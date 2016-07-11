package com.legend.common.core.databus;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.legend.common.config.databus.DataBusConfig;
import com.legend.common.config.databus.conv.DataBusConvConfig;
import com.legend.common.config.exception.ConfigLoadException;
import com.legend.common.core.config.config;
import com.legend.common.core.databus.conv.DataBusConverter;
import com.legend.common.core.exception.DataBusToMapConvException;
import com.legend.common.core.exception.MapToDataBusConvException;


public class DataBusConverterTest {

	@Test
	public void testDataBusConverter() throws  MapToDataBusConvException, DataBusToMapConvException, ConfigLoadException {
		DataBusConvConfig dataBusConvConfig = new DataBusConvConfig(config.TPS_CONFIG);
		DataBusConverter dataBusConverter = new DataBusConverter(dataBusConvConfig);
		DataBusConfig dataBusConfig = new DataBusConfig(config.TPS_CONFIG+"DataDicMap.xml");
		DataBus dataBus = new DataBus(dataBusConfig);
		Map<String,Object> src = new HashMap<String,Object>();
		String source = "123";
		src.put("cartoon.message.id", source);
		src.put("cartoon.message.cpreq.amount", 622.00);
		dataBusConverter.toDataBus("CPReq_I", src,dataBus);
		System.out.println(dataBus);
		Map<String,Object> des = new HashMap<String,Object>();
		dataBusConverter.toMap("CPReq_O", dataBus,des);
		System.out.println(des);
		String destination = (String) des.get("/Cartoon/CpReq/id/dd");
		Assert.assertEquals(source, destination);
	}

}
