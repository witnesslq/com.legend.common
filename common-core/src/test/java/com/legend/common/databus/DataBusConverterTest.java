package com.legend.common.databus;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.legend.common.exception.ConvConfigNotFoundException;
import com.legend.common.exception.DataBusLoadException;
import com.legend.common.exception.DataConvLoadException;
import com.legend.common.exception.IllegalDataBusKeyException;
import com.legend.common.exception.IllegalDataBusTypeException;

public class DataBusConverterTest {

	@Test
	public void testDataBusConverter() throws DataBusLoadException, DataConvLoadException, ConvConfigNotFoundException, IllegalDataBusKeyException, IllegalDataBusTypeException {
		DataBusConverter dataBusConverter = new DataBusConverter("DataDicMap.xml","conv");
		Map<String,Object> src = new HashMap<String,Object>();
		src.put("/Cartoon/CpReq/id", "123");
		DataBus dataBus = dataBusConverter.toDataBus("CpReq_I", src);
		System.out.println(dataBus);
		Map<String,Object> des = dataBusConverter.toMap("CpReq_O", dataBus);
		System.out.println(des);
		System.out.println(des.get("/Cartoon/CpReq/id/dd"));
	}

}
