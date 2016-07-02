package com.legend.common.core.comm.codeFactory.LenValueCode;

import org.apache.mina.core.buffer.IoBuffer;

public class Context {
	
	private int Len = 0;
	private int remainLen = 0;
	private IoBuffer bufferLen = null;
	private IoBuffer bufferContext = null;
	
	public Context(int len) {
		bufferLen = IoBuffer.allocate(len);
		bufferContext = IoBuffer.allocate(1024).setAutoExpand(true);
	}
	
	public int getLen() {
		return Len;
	}
	public void setLen(int len) {
		Len = len;
	}
	public int getRemainLen() {
		return remainLen;
	}
	public void setRemainLen(int remainLen) {
		this.remainLen = remainLen;
	}
	public IoBuffer getBufferLen() {
		return bufferLen;
	}
	public void setBufferLen(IoBuffer bufferLen) {
		this.bufferLen = bufferLen;
	}
	public IoBuffer getBufferContext() {
		return bufferContext;
	}
	public IoBuffer setBufferContext(IoBuffer bufferContext) {
		this.bufferContext = bufferContext;
		return this.bufferContext;
	}
	
	public void reset(){
		this.Len = 0;
		this.remainLen = 0;
		this.bufferLen.clear();
		this.bufferContext.clear();
	}

	@Override
	public String toString() {
		return "Context [Len=" + Len + ", remainLen=" + remainLen + ", bufferLen=" + bufferLen + ", bufferContext="
				+ bufferContext + "]";
	}
	
	
}
