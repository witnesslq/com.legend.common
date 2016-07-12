package com.legend.common.config.rspcode;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.config.exception.ConfigLoadException;

public class RspCodeConfig {
	
	private static Logger logger = LoggerFactory.getLogger(RspCodeConfig.class);
	
	private Map<String, Map<String, String>> rspCodeConv = new HashMap<String, Map<String, String>>();
	
	private RspCodeMap rspCodeMap;

	public RspCodeConfig(String convFileDirectName) throws ConfigLoadException{
		loadRspCodeMap(convFileDirectName);
		logger.info("装载响应码转换配置文件成功！！！");
	}
	
	private void loadRspCodeMap(String convFileDirectPath) throws ConfigLoadException {
		if (convFileDirectPath == null) {
			throw new ConfigLoadException("装载响应码转换配置文件错误[" + convFileDirectPath + "]");
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
						throw new ConfigLoadException("装载响应码转换配置文件错误[" + convFileName + "]");
					}
					mapInToOut.put(rspCodeMap.getDefaultErrorInCode(), rspCodeMap.getDefaultErrorOutCode());
					mapOutToIn.put(rspCodeMap.getDefaultErrorOutCode(), rspCodeMap.getDefaultErrorInCode());
					this.rspCodeConv.put(key+"_InToOut", mapInToOut);
					this.rspCodeConv.put(key+"_OutToIn", mapOutToIn);
				} else if (fileList[i].isDirectory()) {
					loadRspCodeMap(fileList[i].getPath());
				}
			}
		} catch (JAXBException e) {
			throw new ConfigLoadException("装载响应码转换配置文件错误[" + convFileDirectPath + "]" + e);
		}
	}

	public Map<String, Map<String, String>> getRspCodeConv() {
		return rspCodeConv;
	}

	public void setRspCodeConv(Map<String, Map<String, String>> rspCodeConv) {
		this.rspCodeConv = rspCodeConv;
	}

	public RspCodeMap getRspCodeMap() {
		return rspCodeMap;
	}

	public void setRspCodeMap(RspCodeMap rspCodeMap) {
		this.rspCodeMap = rspCodeMap;
	}

}
