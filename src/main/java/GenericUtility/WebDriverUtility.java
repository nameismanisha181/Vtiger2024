package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void fullScreen(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	/**
	 * This method will wait entire page for 20 seconds
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 *T his method will wait for element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVissible(WebDriver driver,WebElement element)
	{
	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	      wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions action= new Actions(driver);
		action.moveToElement(element).perform();
	}
	public void moveToElementAndClick(WebDriver driver,WebElement element)
	{
		Actions action= new Actions(driver);
		action.moveToElement(element).perform();
		action.click().perform();
	}
	
	/*public String getScreenshot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=new File("./errorShots"+screenShotName+".png");
		File dest=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}*/
		
}













