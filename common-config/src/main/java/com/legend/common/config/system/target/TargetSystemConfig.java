package com.legend.common.config.system.target;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.config.exception.ConfigLoadException;

public class TargetSystemConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(TargetSystemConfig.class);
	
	private TargetSystem targetSystem;
	
	public TargetSystemConfig(String targeSystemFilePath) throws ConfigLoadException {
		try {
			JAXBContext jc = JAXBContext.newInstance(TargetSystem.class);
			Unmarshaller ums = jc.createUnmarshaller();
			logger.info("装载目标系统通讯信息[" + targeSystemFilePath + "]");
			this.targetSystem = (TargetSystem) ums.unmarshal(new File(targeSystemFilePath));
		} catch (JAXBException e) {
			throw new ConfigLoadException("装载目标系统通讯信息文件错误[" + targeSystemFilePath + "]" + e);
		}
		
		if(this.targetSystem.getCodecFactory()==null){
			throw new ConfigLoadException("目标系统通讯协议类型未配置");
		}
	}

	public TargetSystem getTargetSystem() {
		return targetSystem;
	}

	public void setTargetSystem(TargetSystem targetSystem) {
		this.targetSystem = targetSystem;
	}

}
