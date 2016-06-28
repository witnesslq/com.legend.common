package com.legend.common.comm.codeFactory;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//编码
public class LenValueCodecEncoder extends ProtocolEncoderAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(LenValueCodecEncoder.class);
	private Charset charset;
	private int valueLen;
	
	public LenValueCodecEncoder(Charset charset,int valueLen){
		this.charset = charset;
		this.valueLen = valueLen;
	}

	@Override
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
		int len = message.toString().length();
		StringBuffer sb = new StringBuffer(String.format("%0"+this.valueLen+"d", len));
		sb.append(message);
		logger.info("转码后待发送数据=["+sb.toString()+"]");
		IoBuffer buffer = IoBuffer.allocate(len+this.valueLen);
		buffer.put(sb.toString().getBytes(this.charset));
		buffer.flip();
		out.write(buffer);
	}

	@Override
	public void dispose(IoSession session) throws Exception {
		logger.info("in dispose");

	}

}
