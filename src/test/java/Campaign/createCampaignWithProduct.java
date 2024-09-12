package Campaign;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createCampaignWithProduct {
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
	
	Thread.sleep(3000);
	//get product name from excel
	String prodName = eUtil.getDataFromExcel("Products", 1, 0);
	int random = jUtil.getRandomNumber();
	prodName=prodName+random;
	System.out.println(prodName);
	
	//create product
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	driver.findElement(By.name("productname")).sendKeys(prodName);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//click on more link and then click on campaign
	driver.findElement(By.linkText("More")).click();	
	driver.findElement(By.linkText("Campaigns")).click();	
	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	
	//get campaign data from excel
	String campaignName = eUtil.getDataFromExcel("Campaign", 1, 0);
	int ran = jUtil.getRandomNumber();
	campaignName=campaignName+ran;
	System.out.println(campaignName);
	
	driver.findElement(By.name("campaignname")).sendKeys(campaignName);
	driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
	
	//switching to product window
	Set<String> ids = driver.getWindowHandles();
	for(String S:ids)
	{
		driver.switchTo().window(S);
		if(driver.getTitle().contains("Products&action"))
		{
			break;
		}
	}
	driver.findElement(By.name("search_text")).sendKeys(prodName);
	driver.findElement(By.name("search")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();	
	
	//switching back to campaign window
	Set<String> idds = driver.getWindowHandles();
	for(String S:idds)
	{
		driver.switchTo().window(S);
		if(driver.getTitle().contains("Campaigns&action"))
		{
			break;
		}
	}
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//Sign Out from application 
		WebElement signOutIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.moveToElement(driver, signOutIcon);
		WebElement SignOutButton = driver.findElement(By.linkText("Sign Out"));
		wUtil.moveToElementAndClick(driver, SignOutButton);
}
}















