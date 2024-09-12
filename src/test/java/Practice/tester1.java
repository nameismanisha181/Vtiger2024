package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tester1 {

	@Test
	public void demoForCrossBrowser()
	{
		WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
	}
}
