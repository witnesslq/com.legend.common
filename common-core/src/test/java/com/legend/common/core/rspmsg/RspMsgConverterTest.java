package com.legend.common.core.rspmsg;

import org.junit.Assert;
import org.junit.Test;

import com.legend.common.core.config.config;
import com.legend.common.core.exception.RspMsgConvException;
import com.legend.common.core.exception.RspMsgConvLoadException;

public class RspMsgConverterTest {
	
	@Test
	public void testRspCodeConverter() throws RspMsgConvLoadException, RspMsgConvException {
		RspMsgConverter rspMsgConverter = new RspMsgConverter(config.TPS_CONFIG);
		String message = rspMsgConverter.getMessage("tps", "0000");
		String message1 = rspMsgConverter.getMessage("tps", "9999");
		Assert.assertEquals(message, "交易成功");
		Assert.assertEquals(message1, "交易失败");
	}
	
}
