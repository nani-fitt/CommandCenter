package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHelper {
	
		public static Properties loadData() throws IOException {
			FileInputStream file = new FileInputStream("./src/properties/browser.properties");
			Properties p = new Properties();
			p.load(file);
			String env= p.getProperty("Environment");
			try {
				if (env.equalsIgnoreCase("dev")) {
					FileInputStream f = new FileInputStream("./src/properties/testDataDev.properties");
					p.load(f);
				}
				else if (env.equalsIgnoreCase("demo")) {
					FileInputStream f = new FileInputStream("./src/properties/testDataDemo.properties");
					p.load(f);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return p;
		}
	}


