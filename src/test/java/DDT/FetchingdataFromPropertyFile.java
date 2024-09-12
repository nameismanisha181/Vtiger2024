package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchingdataFromPropertyFile {
public static void main(String[] args) throws IOException, InterruptedException {
	
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	//driver.get("https://www.saucedemo.com/");
	
	FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
	Properties prop=new Properties();
	prop.load(fis);
	
	String URL = prop.getProperty("url");
	String USERNAME = prop.getProperty("username");
	String PASSWORD = prop.getProperty("password");
	
	driver.get(URL);
	
	driver.findElement(By.id("user-name")).sendKeys(USERNAME);
	driver.findElement(By.id("password")).sendKeys(PASSWORD);
	Thread.sleep(3000);
	driver.findElement(By.id("login-button")).click();
	

	
	
}
}
