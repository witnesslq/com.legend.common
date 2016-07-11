package com.legend.common.config.pack.p8583;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.legend.common.config.exception.ConfigLoadException;

public class Pack8583Config {
	
	private static Logger logger = LoggerFactory.getLogger(Pack8583Config.class);
	
	private Pack8583DicMap pack8583DicMap;
	
	public Pack8583Config(String dataDicFilePath) throws  ConfigLoadException{
		if (dataDicFilePath == null) {
			throw new ConfigLoadException("装载8583数据字典配置文件错误[" + dataDicFilePath + "]");
		}
		try {
			JAXBContext jc = JAXBContext.newInstance(Pack8583DicMap.class);
			Unmarshaller ums = jc.createUnmarshaller();
			logger.info("装载8583数据字典配置文件[" + dataDicFilePath + "]");
			this.pack8583DicMap = (Pack8583DicMap) ums.unmarshal(new File(dataDicFilePath));
		} catch (JAXBException e) {
			throw new ConfigLoadException("装载8583数据字典配置文件错误[" + dataDicFilePath + "]" + e);
		}

		logger.info("装载8583数据字典配置文件成功！！！");
	}

	public Pack8583DicMap getPack8583DicMap() {
		return pack8583DicMap;
	}

	public void setPack8583DicMap(Pack8583DicMap pack8583DicMap) {
		this.pack8583DicMap = pack8583DicMap;
	}
	
}
