package Organization;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CreateNewOrgnizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrgnizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createOrgnization {
public static void main(String[] args) throws IOException, InterruptedException {
	
	WebDriver driver=null;
	PropertyFileUtility pUtil= new PropertyFileUtility();
	JavaUtility jUtil=new JavaUtility();
	ExcelFileUtility eUtil= new ExcelFileUtility();
	WebDriverUtility wUtil= new WebDriverUtility();
	
	
   String BROWSER = pUtil.readDataFromProperttyFile("browser");
	
	if(BROWSER.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else if(BROWSER.equals("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	wUtil.maximizeWindow(driver);
	
	//read data from property file
	String URL = pUtil.readDataFromProperttyFile("url");
	String USERNAME = pUtil.readDataFromProperttyFile("username");
	String PASSWORD=pUtil.readDataFromProperttyFile("password");
	

	
	if(BROWSER.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	//login to application
	driver.get(URL);
	LoginPage lp = new LoginPage(driver);
	lp.LoginToApplication(USERNAME, PASSWORD);
	
	//click on Organization
	HomePage hp= new HomePage(driver);
	hp.ClickOnOrgnization();
	
	OrgnizationPage op= new OrgnizationPage(driver);
	op.clickCreateOrgnizationImage();
	
	//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();	
	//fetch OrgName,Phone Number,Email address from excel sheet
	
	String OrgName = eUtil.getDataFromExcel("Organization", 1,0);
	//String phoneNumber = eUtil.getDataFromExcel("Organization", 1,1);
	//String phoneNumber = eUtil.getDataFromExcel("Organization",  1,1);
	String emailAddress = eUtil.getDataFromExcel("Organization", 1, 2);	
	
	System.out.println(OrgName);
    //System.out.println(phoneNumber);
	System.out.println(emailAddress);
	
	//create Organization
	int ranNumber = jUtil.getRandomNumber();
	OrgName=OrgName+ranNumber;
	System.out.println(OrgName);
	
	CreateNewOrgnizationPage cno=new CreateNewOrgnizationPage(driver);
	cno.createOrgnization(OrgName,emailAddress);
	
	/*driver.findElement(By.name("accountname")).sendKeys(OrgName);
	driver.findElement(By.id("email1")).sendKeys(emailAddress);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
	Thread.sleep(3000);
	
	//SignOut from application
	hp.SignOut(driver);	
		
}
}













