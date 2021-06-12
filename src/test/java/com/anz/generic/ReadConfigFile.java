package com.anz.generic;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ReadConfigFile {
	 protected Properties prop = null;
	 protected InputStream input = null;
	 public ReadConfigFile() {
	 BufferedReader reader;
	 try {
	 reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+ Constant.CONFIG_PROPERTIES_DIRECTORY));
	 prop = new Properties();
	 try {
	 prop.load(reader);
	 reader.close();
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 } catch (FileNotFoundException e) {
	 e.printStackTrace();
	 throw new RuntimeException("Configuration.properties not found at " + System.getProperty("user.dir")+ Constant.CONFIG_PROPERTIES_DIRECTORY);
	 }
	 }
	
	 public String getBrowser() {
	 if (prop.getProperty("browser") == null)
	 return "Browser not defined";
	 return prop.getProperty("browser");
	 
	
	
	 }
	 
		public String getURL() {
		if(prop.getProperty("AnzURL")==null)
			return "URL is not Mentioned";
		return prop.getProperty("AnzURL");
	}
		
		public String getwait() {
			if(prop.getProperty("implicitlyWait")==null)
				return "";
			return prop.getProperty("implicitlyWait");
			
		}
	

}
