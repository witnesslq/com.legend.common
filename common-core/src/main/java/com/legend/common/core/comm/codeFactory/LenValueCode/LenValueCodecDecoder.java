package com.legend.common.core.comm.codeFactory.LenValueCode;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoderAdapter;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//解码
public class LenValueCodecDecoder extends ProtocolDecoderAdapter {

	private static final Logger logger = LoggerFactory.getLogger(LenValueCodecDecoder.class);
	private Charset charset;
	private int lenValue;
	private final String Context = LenValueCodecDecoder.class.getSimpleName()+".context";
	private Context context = null;
	
	public LenValueCodecDecoder(Charset charset,int lenValue){
		this.charset = charset;
		this.lenValue = lenValue;
	}
	
	@Override
	public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		
		context =  (com.legend.common.core.comm.codeFactory.LenValueCode.Context) session.getAttribute(Context);
		if(context == null){
			logger.info("新连接，创建临时缓存对象");
			context = new Context(this.lenValue);
			session.setAttribute(Context,context);
		}
		
		IoBuffer bufferLen= context.getBufferLen();
		IoBuffer bufferContext = context.getBufferContext();
		int remainLen = context.getRemainLen();
		int len = context.getLen();
		
		while(in.hasRemaining()){
			byte b = in.get();
			++len;
			if(len<=this.lenValue){
				bufferLen.put(b);
				if(len==this.lenValue){		//长度读取完毕
					bufferLen.flip();
					try{
						remainLen=Integer.valueOf(bufferLen.getString(this.charset.newDecoder()));
						logger.info("报文长度=["+remainLen+"]");
					}catch(NumberFormatException e){
						throw new NumberFormatException("接收报文长度异常"+context);
					}
				}
			}else{
				--remainLen;
				bufferContext.put(b);
				if(remainLen==0){
					break;
				}
			}
			context.setLen(len);
			context.setRemainLen(remainLen);
		}
		if(remainLen==0 && len>this.lenValue){
			bufferContext.flip();
			try{
				byte[] dst = new byte[bufferContext.remaining()];
				bufferContext.get(dst);
				out.write(dst);
			}finally{
				context.reset();
			}
		}
		
		logger.info(context.toString());
	}

	@Override
	public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
		Context context =  (com.legend.common.core.comm.codeFactory.LenValueCode.Context) session.getAttribute(Context);
		if(context!=null){
			session.removeAttribute(Context);
		}
		logger.info("解码完成");
	}

	@Override
	public void dispose(IoSession session) throws Exception {
		logger.info("连接断开");
	}

}
