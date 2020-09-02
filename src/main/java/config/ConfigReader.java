package config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import common.CommonConstants;

public class ConfigReader {

	private Properties properties;
	private final String propertyFilePath = CommonConstants.PROPERTY_FILE_PATH;
	private static ConfigReader configReader = null;

	public ConfigReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("EnvironmentDetails.properties file not found at" + propertyFilePath);
		}
	}
	
	public Properties getProperties() {
		return properties;
	}
	
	public static ConfigReader getInstance() {
		if(configReader == null) {
			configReader = new ConfigReader();
		}
		return configReader;
	}	

}
