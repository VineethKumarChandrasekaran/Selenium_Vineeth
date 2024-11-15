package genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String properties(String Key) throws IOException {
		FileInputStream file = new FileInputStream("./src/test/resource/TestData/demoapplication.properties");
		Properties properties = new Properties();
		properties.load(file);
		return properties.getProperty(Key);
	}
}
