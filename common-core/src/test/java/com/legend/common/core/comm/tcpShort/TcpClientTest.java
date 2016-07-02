package com.legend.common.core.comm.tcpShort;

import java.io.UnsupportedEncodingException;

import org.apache.mina.core.session.IoSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.legend.common.core.config.config;
import com.legend.common.core.exception.TcpShortConnectException;
import com.legend.common.core.exception.TcpShortLoadException;
import com.legend.common.core.exception.TcpShortRcvTimeOutException;

public class TcpClientTest {
	
	@Before
	public void init(){
		new MinaService().listen();
	}

	@Test
	public void testConnect() throws TcpShortLoadException, TcpShortConnectException, TcpShortRcvTimeOutException, UnsupportedEncodingException {
		TcpClient tcpClient = new TcpClient(config.TPS_CONFIG+"host/TcpShortTargetSystem.xml");
		IoSession session = tcpClient.connect();
		String reqMsg = "测试Socket短连接，123";
		byte[] rspByte = (byte[]) tcpClient.comm(session, reqMsg.getBytes("UTF-8"));
		String rspMsg = new String(rspByte,"UTF-8");
		tcpClient.disconnect(session);
		Assert.assertEquals(reqMsg,rspMsg);
	}

}
