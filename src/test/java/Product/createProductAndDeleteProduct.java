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

public class createProductAndDeleteProduct {
public static void main(String[] args) throws IOException, InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();	
	
	PropertyFileUtility pUtil=new PropertyFileUtility();
	JavaUtility jUtil=new JavaUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	
	//read data from property file
	String URL = pUtil.readDataFromProperttyFile("url");
	String USERNAME = pUtil.readDataFromProperttyFile("username");
	String PASSWORD = pUtil.readDataFromProperttyFile("password");
	
	//login to application
	driver.get(URL);
	wUtil.maximizeWindow(driver);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();	
	Thread.sleep(5000);
	
	//create product
	
	String prodName = eUtil.getDataFromExcel("Products", 1, 0);
	int ran = jUtil.getRandomNumber();
	prodName=prodName+ran;
	System.out.println(prodName);
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	driver.findElement(By.name("productname")).sendKeys(prodName);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//move to product tab to delete product
	Thread.sleep(5000);
	driver.findElement(By.linkText("Products")).click();
	
	//xpath to select product name
	//table[@class='lvt small']/tbody/tr//td//a[text()='Product Name']/../preceding-sibling::td[2]
	//dynamix xpath to select product name
	 driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+prodName+"']/../preceding-sibling::td[2]")).click();
	
	 
	 //driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='" + prodName + "']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
	driver.findElement(By.xpath("//input[@value='Delete']")).click();
	driver.switchTo().alert().accept();
	
	//Sign Out from application 
		WebElement signOutIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.moveToElement(driver, signOutIcon);
		WebElement SignOutButton = driver.findElement(By.linkText("Sign Out"));
		wUtil.moveToElementAndClick(driver, SignOutButton);
}
}


















