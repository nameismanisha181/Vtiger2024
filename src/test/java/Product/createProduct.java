package Product;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createProduct {
public static void main(String[] args) throws IOException, InterruptedException {
	PropertyFileUtility pUtil= new PropertyFileUtility();
	JavaUtility jUtil=new JavaUtility();
	ExcelFileUtility eUtil= new ExcelFileUtility();
	WebDriverUtility wUtil= new WebDriverUtility();
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	wUtil.maximizeWindow(driver);
	
	//read data from property file
	String URL = pUtil.readDataFromProperttyFile("url");
	String USERNAME = pUtil.readDataFromProperttyFile("username");
	String PASSWORD=pUtil.readDataFromProperttyFile("password");
	
	//login to application
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	Thread.sleep(3000);
		
	//fetch product name from excel
	String proName = eUtil.getDataFromExcel("Products", 1, 0);
	int ran = jUtil.getRandomNumber();
	proName=proName+ran;
	
	//create product flow
	driver.findElement(By.linkText("Products")).click();	
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	
	driver.findElement(By.name("productname")).sendKeys(proName);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//SignOut from application
		WebElement signOutIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.moveToElement(driver, signOutIcon);
		Thread.sleep(4000);
		WebElement signOutButton = driver.findElement(By.linkText("Sign Out"));
		wUtil.moveToElementAndClick(driver, signOutButton);		
	
}
}









