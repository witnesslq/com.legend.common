package com.legend.common.core.rspmsg;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.config.rspmsg.RspMsgConfig;
import com.legend.common.config.rspmsg.RspMsgMap;
import com.legend.common.core.exception.RspMsgConvException;

public class RspMsgConverter {

	private static Logger logger = LoggerFactory.getLogger(RspMsgConverter.class);

	private Map<String, Map<String, String>> rspMsgConv = new HashMap<String, Map<String, String>>();
	
	private RspMsgMap rspMsgMap;

	public RspMsgConverter(RspMsgConfig rspMsgConfig)  {
		this.rspMsgMap = rspMsgConfig.getRspMsgMap();
		this.rspMsgConv = rspMsgConfig.getRspMsgConv();
	}

	public String getMessage(String idConv, String code) throws RspMsgConvException { 
		if(code==null){
			throw new RspMsgConvException("需要转换的响应码不能为空");
		}
		Map<String, String> convMap = this.rspMsgConv.get(idConv);
		if (convMap == null) {
			throw new RspMsgConvException("转换标识[" + idConv + "]尚未配置");
		}
		String message = convMap.get(code);
		if(message == null){
			message = code;
		}
		return message;
	}

}
