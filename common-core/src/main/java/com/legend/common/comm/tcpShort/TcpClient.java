package com.legend.common.comm.tcpShort;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.mina.core.future.CloseFuture;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.ReadFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.comm.codeFactory.LenValueCode.LenValueCodecFactory;
import com.legend.common.exception.TcpShortConnectException;
import com.legend.common.exception.TcpShortLoadException;
import com.legend.common.exception.TcpShortRcvTimeOutException;

public class TcpClient {

	private static final Logger logger = LoggerFactory.getLogger(TcpClient.class);

	private IoConnector connector;
	private TargetSystem targetSystem;

	public TcpClient(String targeSystemFilePath) throws TcpShortLoadException {

		try {
			JAXBContext jc = JAXBContext.newInstance(TargetSystem.class);
			Unmarshaller ums = jc.createUnmarshaller();
			logger.info("装载目标系统通讯信息[" + targeSystemFilePath + "]");
			this.targetSystem = (TargetSystem) ums.unmarshal(new File(targeSystemFilePath));
		} catch (JAXBException e) {
			throw new TcpShortLoadException("装载目标系统通讯信息文件错误[" + targeSystemFilePath + "]" + e);
		}

		connector = new NioSocketConnector();
		connector.getSessionConfig().setMinReadBufferSize(1024);
		connector.getSessionConfig().setMaxReadBufferSize(2048);

		if (this.targetSystem.isUseLog()) {
			logger.info("开启通讯日志");
			connector.getFilterChain().addLast("logging", new LoggingFilter());
		}
		logger.info("通讯协议类型=[" + this.targetSystem.getCodecFactory().getValue().value() + "]");
		if (this.targetSystem.getCodecFactory().getValue().value().equals("LenValueCodecFactory")) {
			connector.getFilterChain().addLast("Codec",
					new ProtocolCodecFilter(new LenValueCodecFactory(
							Charset.forName(this.targetSystem.getCodecFactory().getCharsetName()),
							this.targetSystem.getCodecFactory().getLen())));
		}

		connector.setHandler(new IoHandlerAdapter());
	}

	public IoSession connect() throws TcpShortConnectException {
		IoSession session = null;
		ConnectFuture future = connector
				.connect(new InetSocketAddress(this.targetSystem.getTargetIp(), this.targetSystem.getTargetPort()));
		future.awaitUninterruptibly(); // 等待连接成功
		if (future.isConnected()) {
			logger.info(
					"目标系统[" + this.targetSystem.getTargetIp() + "][" + this.targetSystem.getTargetPort() + "]连接建立成功");
			session = future.getSession();
			session.getConfig().setUseReadOperation(true); // 设置同步读取应答
		} else {
			throw new TcpShortConnectException(
					"目标系统[" + this.targetSystem.getTargetIp() + "][" + this.targetSystem.getTargetPort() + "]连接建立失败");
		}
		return session;
	}

	public Object comm(IoSession session, Object send) throws TcpShortRcvTimeOutException {

		session.write(send).awaitUninterruptibly();

		ReadFuture readFuture = session.read();

		if (readFuture.awaitUninterruptibly(this.targetSystem.getWaitTimeout(), TimeUnit.SECONDS)) {
			Object message = readFuture.getMessage();
			try {
				logger.info("收到目标系统应答报文[" + new String((byte[]) message, "UTF-8") + "]");
			} catch (UnsupportedEncodingException e) {
				logger.error("收到目标系统应答报文不是UTF-8编码");
			}
			return message;
		} else {
			throw new TcpShortRcvTimeOutException(
					"目标系统[" + this.targetSystem.getTargetIp() + "][" + this.targetSystem.getTargetPort() + "]通讯超时");
		}

	}

	public void disconnect(IoSession session) {
		CloseFuture closeFutrue = session.getCloseFuture();
		closeFutrue.awaitUninterruptibly();
		if (closeFutrue.isClosed()) {
			logger.info(
					"目标系统[" + this.targetSystem.getTargetIp() + "][" + this.targetSystem.getTargetPort() + "]断开连接成功");
		}
	}

}
