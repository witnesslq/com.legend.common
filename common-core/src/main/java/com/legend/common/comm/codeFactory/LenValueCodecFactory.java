package com.legend.common.comm.codeFactory;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class LenValueCodecFactory implements ProtocolCodecFactory {
	
	private Charset charset;
	private int len;
	
	public LenValueCodecFactory(Charset charset,int len){
		this.charset = charset;
		this.len = len;
	}

	@Override
	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		return new LenValueCodecEncoder(charset,len);
	}

	@Override
	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		return new LenValueCodecDecoder(charset,len);
	}

}
