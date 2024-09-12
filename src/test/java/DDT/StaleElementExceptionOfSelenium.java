package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementExceptionOfSelenium {
public static void main(String[] args) {
	

	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");	
	driver.findElement(By.name("user_password")).sendKeys("admin");
	WebElement submitButton = driver.findElement(By.id("submitButton"));
	
	driver.navigate().refresh();
	submitButton.click();
	
}
}
