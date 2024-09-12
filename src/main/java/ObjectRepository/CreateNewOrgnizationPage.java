package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgnizationPage {

	public CreateNewOrgnizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement OrgnizationNameTextBox;
	
	@FindBy(id = "phone")
	private WebElement PhoneTextBox;
	
	
	//@FindBys({@FindBy(id = "email1"), @FindBy(name ="email1")})
	@FindBy(name = "email1")
	private WebElement EmailIdTextBox;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	/**
	 * This method is used to create new Organization
	 * @param OrgnisationName
	 * @param Phone
	 * @param emailId
	 */
	public void createOrgnization(String OrgnisationName,String emailId)
	{
		OrgnizationNameTextBox.sendKeys(OrgnisationName);
	//	PhoneTextBox.sendKeys(PhoneNumber);
		EmailIdTextBox.sendKeys(emailId);
		SaveButton.click();		
	}
	
	
}
