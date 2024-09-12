package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement UserNameText;
	
	@FindBy(name = "user_password")
	private WebElement PasswordText;

	@FindBy(id = "submitButton")
	private WebElement SubmitButton;
	
	public void LoginToApplication(String UN,String PASS)
	{
		UserNameText.sendKeys(UN);
		PasswordText.sendKeys(PASS);
		SubmitButton.submit();
	}
	
	
}
