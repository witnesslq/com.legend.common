package com.legend.common.comm.codeFactory.LenValueCode;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.utils.DataUtil;

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
		byte[] mb = (byte[]) message;
		int len = mb.length;
		String sLen = DataUtil.fillZeroLeft(len,8);
		logger.info("转码后待发送数据=["+new String(mb,"UTF-8")+"]");
		IoBuffer buffer = IoBuffer.allocate(len+this.valueLen);
		buffer.put(sLen.getBytes());
		buffer.put(mb);
		buffer.flip();
		out.write(buffer);
	}

	@Override
	public void dispose(IoSession session) throws Exception {
		logger.info("in dispose");

	}

}
