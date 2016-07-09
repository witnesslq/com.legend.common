package com.legend.common.core.rspmsg;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.core.exception.RspMsgConvException;
import com.legend.common.core.exception.RspMsgConvLoadException;

public class RspMsgConverter {

	private static Logger logger = LoggerFactory.getLogger(RspMsgConverter.class);

	private Map<String, Map<String, String>> conv = new HashMap<String, Map<String, String>>();
	
	private RspMsgMap rspMsgMap;

	public RspMsgConverter(String convFileDirectName) throws RspMsgConvLoadException {
		loadRspMsgMap(convFileDirectName);
		logger.info("装载响应信息转换配置文件成功！！！");
	}

	private void loadRspMsgMap(String convFileDirectPath) throws RspMsgConvLoadException {
		if (convFileDirectPath == null) {
			throw new RspMsgConvLoadException("装载响应信息转换配置文件错误[" + convFileDirectPath + "]");
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
					this.conv.put(key, map);
				} else if (fileList[i].isDirectory()) {
					loadRspMsgMap(fileList[i].getPath());
				}
			}
		} catch (JAXBException e) {
			throw new RspMsgConvLoadException("装载响应信息转换配置文件错误[" + convFileDirectPath + "]" + e);
		}
	}

	public String getMessage(String idConv, String code) throws RspMsgConvException { 
		if(code==null){
			throw new RspMsgConvException("需要转换的响应码不能为空");
		}
		Map<String, String> convMap = this.conv.get(idConv);
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
