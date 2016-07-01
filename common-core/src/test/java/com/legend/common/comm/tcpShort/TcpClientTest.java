package com.legend.common.comm.tcpShort;

import org.apache.mina.core.session.IoSession;
import org.junit.Before;
import org.junit.Test;

import com.legend.common.config.config;
import com.legend.common.exception.TcpShortConnectException;
import com.legend.common.exception.TcpShortLoadException;
import com.legend.common.exception.TcpShortRcvTimeOutException;

public class TcpClientTest {
	
	@Before
	public void init(){
		new MinaService().listen();
	}

	@Test
	public void testConnect() throws TcpShortLoadException, TcpShortConnectException, TcpShortRcvTimeOutException {
		TcpClient tcpClient = new TcpClient(config.TPS_CONFIG+"host/TcpShortTargetSystem.xml");
		IoSession session = tcpClient.connect();
		Object bb = tcpClient.comm(session, "ABC".getBytes());
		System.out.println(bb);
		tcpClient.disconnect(session);
	}

}
