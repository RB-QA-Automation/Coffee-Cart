package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	private FileInputStream fis;

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
