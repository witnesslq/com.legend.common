package com.legend.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class PackXmlValidator {
	   public final static String SCHEMA_LANGUAGE = "http://www.w3.org/2001/XMLSchema";  
	   
	    /** 
	     * @param xmlStr 
	     * @param xsdStr 
	     * @return XmlValidateResult 通过Schema验证指定的xml字符串是否符合结构 
	     */  
	    public static XmlValidateResult validateByXsd(String xmlStr, String xsdStr) {  
	        // 查找支持指定模式语言的 SchemaFactory 的实现并返回它  
	        SchemaFactory factory = SchemaFactory  
	                .newInstance(PackXmlValidator.SCHEMA_LANGUAGE);  
	        // 包装待验证的xml字符串为Reader  
	        Reader xmlReader = new BufferedReader(new StringReader(xmlStr));  
	        // 保障Schema xsd字符串为Reader  
	        Reader xsdReader = new BufferedReader(new StringReader(xsdStr));  
	        // 创建返回值类，默认为失败  
	        XmlValidateResult vs = new XmlValidateResult();  
	  
	        try {  
	            // 构造Schema Source  
	            Source xsdSource = new StreamSource(xsdReader);  
	            // 解析作为模式的指定源并以模式形式返回它  
	            Schema schema = factory.newSchema(xsdSource);  
	  
	            // 根据Schema检查xml文档的处理器,创建此 Schema 的新 Validator  
	            Validator validator = schema.newValidator();  
	  
	            // 构造待验证xml Source  
	            Source xmlSource = new StreamSource(xmlReader);  
	  
	            // 执行验证  
	            validator.validate(xmlSource);  
	            // 设置验证通过  
	            vs.setValidated(true);  
	            return vs;  
	        } catch (SAXException ex) {  
	            // 设置验证失败  
	            vs.setValidated(false);  
	            // 设置验证失败信息  
	            vs.setErrorMsg(ex.getMessage());  
	            return vs;  
	        } catch (IOException e) {  
	            // 设置验证失败  
	            vs.setValidated(false);  
	            // 设置验证失败信息  
	            vs.setErrorMsg(e.getMessage());  
	            return vs;  
	        }  
	    }  
	  
	    /** 
	     * @param args0 
	     * @throws IOException 
	     */  
	    public static void main(String[] args0) throws IOException { 
	    	
	        BufferedReader xmlBuff = new BufferedReader(new InputStreamReader(PackXmlValidator.class.getClassLoader().getResourceAsStream("XmlData/beps.121.001.01.xml")));  
	        BufferedReader xsdBuff = new BufferedReader(new InputStreamReader(PackXmlValidator.class.getClassLoader().getResourceAsStream("XmlData/beps.121.001.01.xsd")));  
	  
	  
	        StringBuffer xmlStr = new StringBuffer();  
	        String line = null;  
	        while ((line = xmlBuff.readLine()) != null) {  
	            xmlStr.append(line);  
	            xmlStr.append("\n");  
	        }  
	        xmlBuff.close();  
	  
	        StringBuffer xsdStr = new StringBuffer();  
	        line = null;  
	        while ((line = xsdBuff.readLine()) != null) {  
	            xsdStr.append(line);  
	        }  
	        xsdBuff.close();  
	  
	        XmlValidateResult vs = PackXmlValidator.validateByXsd(xmlStr.toString(),  
	                xsdStr.toString());  
	        if (vs.isValidated()) {  
	            System.out.println("验证成功！");  
	        } else {  
	            System.out.println("验证失败！");  
	            System.out.println("失败原因：" + vs.getErrorMsg());  
	            System.out.println("验证xml：\n" + xmlStr.toString());  
	        }  
	  
	    }  
	}  


class XmlValidateResult {  
    // 是否通过验证  
    private boolean validated;  
  
    // 错误信息  
    private String errorMsg;  
  
    // 构造函数，默认为不通过，错误原因为空字符串  
    XmlValidateResult() {  
        validated = false;  
        errorMsg = "";  
    }  
  
    public String getErrorMsg() {  
        return errorMsg;  
    }  
  
    public void setErrorMsg(String errorMsg) {  
        this.errorMsg = errorMsg;  
    }  
  
    public boolean isValidated() {  
        return validated;  
    }  
  
    public void setValidated(boolean validated) {  
        this.validated = validated;  
    }  
  
}  
