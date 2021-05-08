package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileUtility 
{
	/**
	 * This method is used to read data from the properties and return the value based on key specified
	 * @param key
	 * @return
	 * @author Prem
	 * @throws Throwable 
	 */
	public String getProperyKeyValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
		Properties property = new Properties();
		property.load(fis);
		return property.getProperty(key);
	}
	
	
	/**
	 * This method will return Json value based on the Json key
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Prem
	 */
	public String getDatafromJson(String key) throws Throwable 
	{
		FileReader reader = new FileReader(IPathConstant.JSON_FILEPATH);
		JSONParser parser = new JSONParser();
		Object object = parser.parse(reader);
		JSONObject jsonObject = (JSONObject)object;
		String value = (String)jsonObject.get(key);
		return value;
		

	}


}
