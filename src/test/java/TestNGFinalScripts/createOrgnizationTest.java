package TestNGFinalScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CreateNewOrgnizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrgnizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(GenericUtility.ListenersImplementation.class)
public class createOrgnizationTest extends BaseClass{
	
//@Parameters({"BROWSER"})

@Test(retryAnalyzer=GenericUtility.RetryAnalyserImplementation.class)
public void createOrgnizationTest() throws IOException, InterruptedException
{	
	//WebDriver driver=null;
	PropertyFileUtility pUtil= new PropertyFileUtility();
	JavaUtility jUtil=new JavaUtility();
	ExcelFileUtility eUtil= new ExcelFileUtility();
	WebDriverUtility wUtil= new WebDriverUtility();	
	
	Thread.sleep(5000);
	
	//click on Organization
	HomePage hp= new HomePage(driver);
	hp.ClickOnOrgnization();
	
	Thread.sleep(5000);
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
	System.out.println(ranNumber);
	OrgName=OrgName+ranNumber;
	System.out.println(OrgName);
	
	Thread.sleep(5000);
	CreateNewOrgnizationPage cno=new CreateNewOrgnizationPage(driver);
	cno.createOrgnization(OrgName,emailAddress);
	Thread.sleep(5000);
	
	OrganizationInfoPage OrgInfo= new OrganizationInfoPage(driver);
	String expected = OrgInfo.getOrgnizationName();
	System.out.println(expected);
	
	//Assert.assertEquals(OrgInfo.getOrgnizationName(),OrgName);
	
	Assert.assertEquals(OrgInfo.getOrgnizationName(), OrgName+ranNumber);//This is to fail test case
	Assert.assertEquals(false, true);
	
	
	Thread.sleep(5000);	
	/*driver.findElement(By.name("accountname")).sendKeys(OrgName);
	driver.findElement(By.id("email1")).sendKeys(emailAddress);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
	
	//hp.SignOut(driver);		
}
}