package com.legend.common.core.rspmsg;

import org.junit.Assert;
import org.junit.Test;

import com.legend.common.config.exception.ConfigLoadException;
import com.legend.common.config.rspmsg.RspMsgConfig;
import com.legend.common.core.config.config;
import com.legend.common.core.exception.RspMsgConvException;

public class RspMsgConverterTest {
	
	@Test
	public void testRspCodeConverter() throws  RspMsgConvException, ConfigLoadException {
		RspMsgConfig rspMsgConfig = new RspMsgConfig(config.TPS_CONFIG);
		RspMsgConverter rspMsgConverter = new RspMsgConverter(rspMsgConfig);
		String message = rspMsgConverter.getMessage("tps", "0000");
		String message1 = rspMsgConverter.getMessage("tps", "9999");
		Assert.assertEquals(message, "交易成功");
		Assert.assertEquals(message1, "交易失败");
	}
	
}
