package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicXpath1 {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.prokabaddi.com/standings");
	
	//use of dependant independant xpath
	WebElement wonMatches = driver.findElement(By.xpath("//p[text()='Puneri Paltan']/../../../..//div[@class='table-data matches-won']"));
	System.out.println(wonMatches.getText());
	
	//use of following sibling
	WebElement lostMatches = driver.findElement(By.xpath("//p[text()='Puneri Paltan']/../../../following-sibling::div[@class='table-data matches-lost']"));
	System.out.println(lostMatches.getText());
}
}
