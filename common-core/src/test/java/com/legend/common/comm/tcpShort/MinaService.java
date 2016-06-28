package com.legend.common.comm.tcpShort;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.comm.codeFactory.LenValueCodecFactory;

public class MinaService {
	
	private static final Logger logger = LoggerFactory.getLogger(MinaService.class);
	private static final int port = 9527;
	
	public void listen(){
		IoAcceptor acceptor = new NioSocketAcceptor();
//		acceptor.getSessionConfig().setBothIdleTime(10);
		acceptor.getSessionConfig().setMinReadBufferSize(1024);
		acceptor.getSessionConfig().setMaxReadBufferSize(2048);
		acceptor.getFilterChain().addLast("loggin", new LoggingFilter());
		acceptor.getFilterChain().addLast("valueLenCodec", new ProtocolCodecFilter(new LenValueCodecFactory(Charset.forName("UTF-8"),8)));
		acceptor.setHandler(new MinaServiceHandler());
		try {
			acceptor.bind(new InetSocketAddress(port));
		} catch (IOException e) {
			logger.error("端口绑定失败"+e);
		}
		logger.info("服务端启动监听端口["+port+"]");
	}

	public static void main(String[] args) {
		new MinaService().listen();
	}

}
