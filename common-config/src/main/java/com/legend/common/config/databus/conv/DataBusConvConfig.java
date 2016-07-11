package com.legend.common.config.databus.conv;

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

public class DataBusConvConfig {

	private static Logger logger = LoggerFactory.getLogger(DataBusConvConfig.class);
	
	private Map<String, Map<String, DataConv>> dataBusConv = new HashMap<String, Map<String, DataConv>>();
	
	public DataBusConvConfig(String convFileDirectPath) throws ConfigLoadException{
		loadDataConvMap(convFileDirectPath);
		logger.info("装载数据转换配置文件成功！！！");
	}
	
	private void loadDataConvMap(String convFileDirectPath) throws ConfigLoadException {
		if (convFileDirectPath == null) {
			throw new ConfigLoadException("装载数据转换配置文件错误[" + convFileDirectPath + "]");
		}
		try {
			JAXBContext jc = JAXBContext.newInstance(DataConvMap.class);
			Unmarshaller ums = jc.createUnmarshaller();
			logger.info("数据转换配置文件目录[" + convFileDirectPath + "]");
			File file = new File(convFileDirectPath);
			File[] fileList = file.listFiles();
			for (int i = 0; i < fileList.length; i++) {
				String key = null;
				String fileName = fileList[i].getName();
				if (fileList[i].isFile() && fileName.endsWith(".databus.xml")) {
					key = fileList[i].getName().substring(0, fileName.indexOf("."));
					String convFileName = convFileDirectPath + File.separator + fileName;
					logger.info("装载数据转换配置文件[" + convFileName + "]");
					DataConvMap dataConvMap = (DataConvMap) ums.unmarshal(new File(convFileName));
					Map<String, DataConv> map = new HashMap<String, DataConv>();
					List<DataConv> dataConvs = dataConvMap.getDataConv();
					for (DataConv dataConv : dataConvs) {
						map.put(dataConv.getSource().getValue(), dataConv);
					}
					this.dataBusConv.put(key, map);
				} else if (fileList[i].isDirectory()) {
					loadDataConvMap(fileList[i].getPath());
				}
			}
		} catch (JAXBException e) {
			throw new ConfigLoadException("装载数据转换配置文件错误[" + convFileDirectPath + "]" + e);
		}
	}

	public Map<String, Map<String, DataConv>> getDataBusConv() {
		return dataBusConv;
	}

	public void setDataBusConv(Map<String, Map<String, DataConv>> dataBusConv) {
		this.dataBusConv = dataBusConv;
	}
	
	
}
