package GenericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
/**
 * This generic method will read key from property file and return key
 * @throws IOException 
 */
	public String readDataFromProperttyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./testData/commonData.properties");
		Properties prop= new Properties();
		prop.load(fis);		
		String keyvalue = prop.getProperty(key);
		return keyvalue;
		
	}
}
