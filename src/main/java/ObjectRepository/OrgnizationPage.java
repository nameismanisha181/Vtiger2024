package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnizationPage {

	public OrgnizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgHookUpImage;
	
	public void clickCreateOrgnizationImage()
	{
		createOrgHookUpImage.click();
	}

	public WebElement getCreateOrgHookUpImage() {
		return createOrgHookUpImage;
	}

}
