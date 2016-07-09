package com.legend.common.core.rspcode;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.core.databus.dataconv.DataConv;
import com.legend.common.core.databus.dataconv.DataConv.Format;
import com.legend.common.core.databus.dataconv.DataConv.Source;
import com.legend.common.core.exception.DataBusToMapConvException;
import com.legend.common.core.exception.RspCodeConvException;
import com.legend.common.core.exception.RspCodeConvLoadException;
import com.legend.common.utils.DataUtil;

public class RspCodeConverter {

	private static Logger logger = LoggerFactory.getLogger(RspCodeConverter.class);

	private Map<String, Map<String, String>> conv = new HashMap<String, Map<String, String>>();
	
	private RspCodeMap rspCodeMap;

	public RspCodeConverter(String convFileDirectName) throws RspCodeConvLoadException {
		loadRspCodeMap(convFileDirectName);
		logger.info("装载响应码转换配置文件成功！！！");
	}

	private void loadRspCodeMap(String convFileDirectPath) throws RspCodeConvLoadException {
		if (convFileDirectPath == null) {
			throw new RspCodeConvLoadException("装载响应码转换配置文件错误[" + convFileDirectPath + "]");
		}
		try {
			JAXBContext jc = JAXBContext.newInstance(RspCodeMap.class);
			Unmarshaller ums = jc.createUnmarshaller();
			logger.info("数据转换配置文件目录[" + convFileDirectPath + "]");
			File file = new File(convFileDirectPath);
			File[] fileList = file.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				String key = null;
				String fileName = fileList[i].getName();
				if (fileList[i].isFile() && fileName.endsWith(".rspcode.xml")) {
					key = fileList[i].getName().substring(0, fileName.indexOf("."));
					String convFileName = convFileDirectPath + File.separator + fileName;
					logger.info("装载响应码转换配置文件[" + convFileName + "]");
					rspCodeMap = (RspCodeMap) ums.unmarshal(new File(convFileName));
					Map<String, String> mapInToOut = new HashMap<String, String>();
					Map<String, String> mapOutToIn = new HashMap<String, String>();
					List<RspCode> rspCodes = rspCodeMap.getRspCode();
					for (RspCode rspCode : rspCodes) {
						mapInToOut.put(rspCode.getInner(), rspCode.getOutter());
						mapOutToIn.put(rspCode.getOutter(), rspCode.getInner());
					}
					if(rspCodeMap.getDefaultErrorInCode()==null ||  rspCodeMap.getDefaultErrorOutCode()==null){
						throw new RspCodeConvLoadException("装载响应码转换配置文件错误[" + convFileName + "]");
					}
					mapInToOut.put(rspCodeMap.getDefaultErrorInCode(), rspCodeMap.getDefaultErrorOutCode());
					mapOutToIn.put(rspCodeMap.getDefaultErrorOutCode(), rspCodeMap.getDefaultErrorInCode());
					this.conv.put(key+"_InToOut", mapInToOut);
					this.conv.put(key+"_OutToIn", mapOutToIn);
				} else if (fileList[i].isDirectory()) {
					loadRspCodeMap(fileList[i].getPath());
				}
			}
		} catch (JAXBException e) {
			throw new RspCodeConvLoadException("装载响应码转换配置文件错误[" + convFileDirectPath + "]" + e);
		}
	}

	public String InToOut(String idConv, String inRspCode) throws RspCodeConvException { // map转换
		if(inRspCode==null){
			throw new RspCodeConvException("需要转换的响应码不能为空");
		}
		Map<String, String> convMap = this.conv.get(idConv+"_InToOut");
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
		Map<String, String> convMap = this.conv.get(idConv+"_OutToIn");
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
