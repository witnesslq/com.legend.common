package com.legend.common.core.databus;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.legend.common.core.config.config;
import com.legend.common.core.exception.DataBusLoadException;
import com.legend.common.core.exception.DataBusToMapConvException;
import com.legend.common.core.exception.DataConvLoadException;
import com.legend.common.core.exception.MapToDataBusConvException;


public class DataBusConverterTest {

	@Test
	public void testDataBusConverter() throws DataBusLoadException, DataConvLoadException, MapToDataBusConvException, DataBusToMapConvException {
		DataBusConverter dataBusConverter = new DataBusConverter(config.TPS_CONFIG);
		DataBus dataBus = new DataBus(config.TPS_CONFIG+"DataDicMap.xml");
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
