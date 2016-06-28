package com.legend.common.comm.tcpShort;

import org.apache.mina.core.session.IoSession;
import org.junit.Before;
import org.junit.Test;

import com.legend.common.exception.TcpShortException;

public class TcpClientTest {
	
	@Before
	public void init(){
		new MinaService().listen();
	}

	@Test
	public void testConnect() throws TcpShortException {
		TcpClient tcpClient = new TcpClient("TcpShortTargetSystem.xml");
		IoSession session = tcpClient.connect();
		Object bb = tcpClient.comm(session, "ABC");
		System.out.println(bb);
		tcpClient.disconnect(session);
	}

}
