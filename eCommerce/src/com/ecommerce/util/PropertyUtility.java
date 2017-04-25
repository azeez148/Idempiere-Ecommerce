package com.ecommerce.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

/**
 * @author srigin.ms
 *
 */
public class PropertyUtility {
	

	private static Properties properties = null;
	
	public PropertyUtility(){
		
		properties = new Properties();
		String fileLocation = null;
		InputStream input = null;

		try {
			fileLocation = System.getenv("TDI_HOME");
			if(fileLocation == null)
				fileLocation = "C:/config.properties" ;
			input = new FileInputStream(fileLocation+"/config.properties");
			properties.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Configuration File Not Found", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @return the properties
	 */
	public static Properties getProperties() {
		return properties;
	}

	
	
	
	

}
