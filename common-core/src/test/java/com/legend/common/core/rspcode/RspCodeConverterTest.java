package com.legend.common.core.rspcode;

import org.junit.Assert;
import org.junit.Test;

import com.legend.common.config.exception.ConfigLoadException;
import com.legend.common.config.rspcode.RspCodeConfig;
import com.legend.common.core.config.config;
import com.legend.common.core.exception.RspCodeConvException;

public class RspCodeConverterTest {
	
	@Test
	public void testRspCodeConverter() throws  RspCodeConvException, ConfigLoadException{
		RspCodeConfig rspCodeConfig = new RspCodeConfig(config.TPS_CONFIG);
		RspCodeConverter rspCodeConverter = new RspCodeConverter(rspCodeConfig);
		String outRspcode = rspCodeConverter.InToOut("host", "9900");
		String inRspcode = rspCodeConverter.OutToIn("host", "77");
		Assert.assertEquals(outRspcode, "99");
		Assert.assertEquals(inRspcode, "7700");
		
		String outRspcode1 = rspCodeConverter.InToOut("host", "AABB");
		String inRspcode1 = rspCodeConverter.OutToIn("host", "CC");
		Assert.assertEquals(outRspcode1, "99");
		Assert.assertEquals(inRspcode1, "9999");
	}
}
