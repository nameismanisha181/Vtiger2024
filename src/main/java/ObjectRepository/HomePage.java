package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class HomePage {

	WebDriverUtility wUtil= new WebDriverUtility();
	//declaration
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement OrgnizationLink;
	
	@FindBy(linkText = "Products")
	private WebElement ProductLink;
	
	//@FindBy(linkText = "More")
	//private WebElement MoreLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOut;
	
	@FindBys({
		      @FindBy(name ="Campaigns"),
		      @FindBy(id="more")		
	         })
	private WebElement CapaignLink;
	
	
	
	public void ClickOnOrgnization()
	{
		OrgnizationLink.click();
	}
	public void clickonProducts()
	{
		ProductLink.click();
	}
/*	public void clickOnMore()
	{
		MoreLink.click();
	}*/
	public void SignOut(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		wUtil.moveToElement(driver, adminIcon);
		wUtil.moveToElementAndClick(driver, SignOut);
	}	
}







