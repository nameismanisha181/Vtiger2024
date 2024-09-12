package DynamicXpath;

import java.util.List;
//search for iphone 13 in amazon and print all colors of phone
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone14");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1200)");
	
	List<WebElement> Allcolors = driver.findElements(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Pink']/../../../..//a[@class='a-link-normal']"));
    for(WebElement W: Allcolors)
    {
    	System.out.println(W.getAttribute("aria-label"));
    }
}
}
