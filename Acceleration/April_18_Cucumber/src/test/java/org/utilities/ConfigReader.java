package org.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {     // URL 
	public String getConfigData(String key) {
		Properties prop =null;
		try {	
			FileInputStream fis = new FileInputStream(
					"./src/test/resources/org/propertiesFile/Config.properties");
			prop = new Properties();
			prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}		
	public Properties getProp() {
		Properties prop = null;
		try {	
			FileInputStream fis = new FileInputStream(
					"./src/test/resources/org/propertiesFile/Config.properties");
			prop = new Properties();
			prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
}