package com.legend.common.databus;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.legend.common.config.config;
import com.legend.common.exception.DataBusLoadException;
import com.legend.common.exception.DataConvLoadException;
import com.legend.common.exception.DatabusConvException;

public class DataBusConverterTest {

	@Test
	public void testDataBusConverter() throws DataBusLoadException, DataConvLoadException, DatabusConvException {
		DataBusConverter dataBusConverter = new DataBusConverter(config.TPS_CONFIG+"DataDicMap.xml",config.TPS_CONFIG);
		Map<String,Object> src = new HashMap<String,Object>();
		src.put("cartoon.message.id", "123");
		DataBus dataBus = new DataBus();
		dataBusConverter.toDataBus("CPReq_I", src,dataBus);
		System.out.println(dataBus);
		Map<String,Object> des = new HashMap<String,Object>();
		dataBusConverter.toMap("CPReq_O", dataBus,des);
		System.out.println(des);
		System.out.println(des.get("/Cartoon/CpReq/id/dd"));
	}

}
