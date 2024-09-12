package GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.json.JsonException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
    public static WebDriver sdriver;
	
//	@Parameters({"BROWSER"})
	@BeforeClass
	public void LaunchBrowser() throws IOException
	{
		PropertyFileUtility prop=new PropertyFileUtility();
		
	    String BROWSER = prop.readDataFromProperttyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
	   sdriver=driver;
	}
	
	@BeforeMethod
	public void LoginToApp() throws IOException, InterruptedException
	{
			
		PropertyFileUtility prop=new PropertyFileUtility();
		WebDriverUtility wutil= new WebDriverUtility();
		
		String URL = prop.readDataFromProperttyFile("url");
		String USERNAME = prop.readDataFromProperttyFile("username");
		String PASSWORD = prop.readDataFromProperttyFile("password");
		
		driver.get(URL);
		Thread.sleep(3000);
		wutil.maximizeWindow(driver);
		Thread.sleep(3000);
		
		LoginPage lp= new LoginPage(driver);
		lp.LoginToApplication(USERNAME, PASSWORD);
	}
	
	@AfterMethod(enabled = false)
	public void SignOutFromApp() throws InterruptedException
	{
		HomePage hp= new HomePage(driver);
		hp.SignOut(driver);
	}
	
	@AfterClass(alwaysRun = true)
	public void CloseBrowser()
	{
		driver.quit();
	}	
}
