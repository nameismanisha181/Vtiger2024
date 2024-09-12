package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicXpath2 {

 public static void main(String[] args) {
	

	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	driver.findElement(By.name("q")).sendKeys("iphone14");
	//
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	
	WebElement price = driver.findElement(By.xpath("//div[text()='Apple iPhone 14 (Blue, 128 GB)']/../..//div[@class='Nx9bqj _4b5DiR']"));
	System.out.println(price.getText());
	
	//use following sibling
}
}
