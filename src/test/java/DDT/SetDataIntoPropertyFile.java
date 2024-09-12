package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SetDataIntoPropertyFile {
public static void main(String[] args) throws IOException {
	
	FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
	
	Properties prop=new Properties();
	prop.load(fis);
	
	prop.setProperty("user1", "modifyvalue");
	System.out.println("Done");
	
	FileOutputStream fos = new FileOutputStream("./src/test/resources/CommonData.properties");
	prop.store(fos, null);
}
}
