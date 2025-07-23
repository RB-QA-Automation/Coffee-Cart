package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * A configuration class which is used for reading the config file and enabling
 * global settings for the framework. Allows for easy control and management for
 * the url, browsers and user information.
 */
public class ConfigReader {

	private Properties prop;
	private FileInputStream fis;

	/**
	 * Initializes and loads the properties from the config.properties file. This
	 * method is key to finding and loading the settings.
	 * 
	 * @return Properties object is returned which contains all the key-value pairs.
	 */
	public Properties init_prop() {

		prop = new Properties();
		try {

			fis = new FileInputStream("src/test/java/resources/config.properties");
			prop.load(fis);

		} catch (IOException e) {

			e.printStackTrace();
		}

		return prop;

	}

}
