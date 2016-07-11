package com.legend.common.config.rspmsg;

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
import com.legend.common.config.rspcode.RspCodeMap;

public class RspMsgConfig {
	
	private static Logger logger = LoggerFactory.getLogger(RspMsgConfig.class);
	
	private Map<String, Map<String, String>> rspMsgConv = new HashMap<String, Map<String, String>>();
	
	private RspMsgMap rspMsgMap;

	public RspMsgConfig(String convFileDirectName) throws ConfigLoadException{
		loadRspMsgMap(convFileDirectName);
		logger.info("装载响应码转换配置文件成功！！！");
	}
	
	private void loadRspMsgMap(String convFileDirectPath) throws ConfigLoadException {
		if (convFileDirectPath == null) {
			throw new ConfigLoadException("装载响应信息转换配置文件错误[" + convFileDirectPath + "]");
		}
		try {
			JAXBContext jc = JAXBContext.newInstance(RspMsgMap.class);
			Unmarshaller ums = jc.createUnmarshaller();
			logger.info("数据转换配置文件目录[" + convFileDirectPath + "]");
			File file = new File(convFileDirectPath);
			File[] fileList = file.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				String key = null;
				String fileName = fileList[i].getName();
				if (fileList[i].isFile() && fileName.endsWith(".rspmsg.xml")) {
					key = fileList[i].getName().substring(0, fileName.indexOf("."));
					String convFileName = convFileDirectPath + File.separator + fileName;
					logger.info("装载响应信息转换配置文件[" + convFileName + "]");
					rspMsgMap = (RspMsgMap) ums.unmarshal(new File(convFileName));
					Map<String, String> map = new HashMap<String, String>();
					List<RspMsg> rspMsgs = rspMsgMap.getRspMsg();
					for (RspMsg rspMsg : rspMsgs) {
						map.put(rspMsg.getCode(),rspMsg.getMessage());
					}
					this.rspMsgConv.put(key, map);
				} else if (fileList[i].isDirectory()) {
					loadRspMsgMap(fileList[i].getPath());
				}
			}
		} catch (JAXBException e) {
			throw new ConfigLoadException("装载响应信息转换配置文件错误[" + convFileDirectPath + "]" + e);
		}
	}

	public Map<String, Map<String, String>> getRspMsgConv() {
		return rspMsgConv;
	}

	public void setRspMsgConv(Map<String, Map<String, String>> rspMsgConv) {
		this.rspMsgConv = rspMsgConv;
	}

	public RspMsgMap getRspMsgMap() {
		return rspMsgMap;
	}

	public void setRspMsgMap(RspMsgMap rspMsgMap) {
		this.rspMsgMap = rspMsgMap;
	}
	

}
