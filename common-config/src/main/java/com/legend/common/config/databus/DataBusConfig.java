package com.legend.common.config.databus;

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

public class DataBusConfig {
	
	private static Logger logger = LoggerFactory.getLogger(DataBusConfig.class);
	
	private Map<String, DataDic> dataBusValidator = new HashMap<String, DataDic>(); // 数据总线数据字典，在进行数据总线导入导出时进行类型检查

	public DataBusConfig(String dataDicFilePath) throws ConfigLoadException {
		DataDicMap dataDicMap = null;
		if (dataDicFilePath == null) {
			throw new ConfigLoadException("装载数据总线数据字典配置文件错误[" + dataDicFilePath + "]");
		}
		try {
			JAXBContext jc = JAXBContext.newInstance(DataDicMap.class);
			Unmarshaller ums = jc.createUnmarshaller();
			logger.info("装载总线数据字典[" + dataDicFilePath + "]");
			dataDicMap = (DataDicMap) ums.unmarshal(new File(dataDicFilePath));
		} catch (JAXBException e) {
			throw new ConfigLoadException("装载数据总线数据字典配置文件错误[" + dataDicFilePath + "]" + e);
		}

		List<DataDic> dataDics = dataDicMap.getDataDic();
		for (DataDic dataDic : dataDics) {
			this.dataBusValidator.put(dataDic.getDataCode(), dataDic);
		}
		
		logger.info("装载数据总线数据字典配置文件成功！！！");
	}

	public Map<String, DataDic> getDataBusValidator() {
		return dataBusValidator;
	}

	public void setDataBusValidator(Map<String, DataDic> dataBusValidator) {
		this.dataBusValidator = dataBusValidator;
	}
	
}
