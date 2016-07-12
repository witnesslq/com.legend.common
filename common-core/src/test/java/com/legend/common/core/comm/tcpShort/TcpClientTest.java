package com.legend.common.core.comm.tcpShort;

import java.io.UnsupportedEncodingException;

import org.apache.mina.core.session.IoSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.legend.common.config.exception.ConfigLoadException;
import com.legend.common.config.system.target.TargetSystemConfig;
import com.legend.common.core.config.config;
import com.legend.common.core.exception.TcpShortConnectException;
import com.legend.common.core.exception.TcpShortRcvTimeOutException;

public class TcpClientTest {
	
	@Before
	public void init(){
		new MinaService().listen();
	}

	@Test
	public void testConnect() throws TcpShortConnectException, TcpShortRcvTimeOutException, UnsupportedEncodingException, ConfigLoadException {
		TargetSystemConfig targetSystemConfig = new TargetSystemConfig(config.TPS_CONFIG+"host/TargetSystem.xml");
		TcpClient tcpClient = new TcpClient(targetSystemConfig);
		IoSession session = tcpClient.connect();
		String reqMsg = "测试Socket短连接，123";
		byte[] rspByte = (byte[]) tcpClient.comm(session, reqMsg.getBytes("UTF-8"));
		String rspMsg = new String(rspByte,"UTF-8");
		tcpClient.disconnect(session);
		Assert.assertEquals(reqMsg,rspMsg);
	}

}
