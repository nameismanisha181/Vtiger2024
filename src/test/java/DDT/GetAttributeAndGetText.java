package DDT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAttributeAndGetText {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.bankbazaar.com/");	
	
	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println("---------getText---------");//prints link name and broken links as blank
	for(WebElement W: links)
	{
		System.out.println(W.getText());
	}
	System.out.println("--------getAttribute--------");//prints all links as href value and not link name
	for(WebElement W: links)
	{
		System.out.println(W.getAttribute("href"));
	}
}
}
