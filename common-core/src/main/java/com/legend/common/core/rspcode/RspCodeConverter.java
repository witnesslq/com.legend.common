package com.legend.common.core.rspcode;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.config.rspcode.RspCodeConfig;
import com.legend.common.config.rspcode.RspCodeMap;
import com.legend.common.core.exception.RspCodeConvException;

public class RspCodeConverter {

	private static Logger logger = LoggerFactory.getLogger(RspCodeConverter.class);

	private Map<String, Map<String, String>> rspCodeConv = new HashMap<String, Map<String, String>>();
	
	private RspCodeMap rspCodeMap;

	public RspCodeConverter(RspCodeConfig rspCodeConfig) {
		this.rspCodeMap = rspCodeConfig.getRspCodeMap();
		this.rspCodeConv = rspCodeConfig.getRspCodeConv();
	}

	public String InToOut(String idConv, String inRspCode) throws RspCodeConvException { // map转换
		if(inRspCode==null){
			throw new RspCodeConvException("需要转换的响应码不能为空");
		}
		Map<String, String> convMap = this.rspCodeConv.get(idConv+"_InToOut");
		if (convMap == null) {
			throw new RspCodeConvException("转换标识[" + idConv + "]尚未配置");
		}
		String outRspCode = convMap.get(inRspCode);
		if(outRspCode == null){
			outRspCode = convMap.get(rspCodeMap.getDefaultErrorInCode());
		}
		return outRspCode;
	}

	public String OutToIn(String idConv, String outRspcode) throws RspCodeConvException { // map转换
		if(outRspcode==null){
			throw new RspCodeConvException("需要转换的响应码不能为空");
		}
		Map<String, String> convMap = this.rspCodeConv.get(idConv+"_OutToIn");
		if (convMap == null) {
			throw new RspCodeConvException("转换标识[" + idConv + "]尚未配置");
		}
		String inRspCode = convMap.get(outRspcode);
		if(inRspCode == null){
			inRspCode = convMap.get(rspCodeMap.getDefaultErrorOutCode());
		}
		return inRspCode;
	}

}
