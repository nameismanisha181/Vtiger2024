package PracticeScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAllLinksIntoExcel {
public static void main(String[] args) throws IOException {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.bankbazaar.com/");
	//step1
	FileInputStream fis = new FileInputStream("./src/test/resources/PrintAllLinks.xlsx");
	
	//step2
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	
	//Step3
	XSSFSheet sheet = workbook.getSheet("Sheet1");
	
	List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	
	for(int i=1;i<=allLinks.size()-1;i++)
	{
		//sheet.createRow(i).createCell(0).setCellValue(allLinks.get(i).getText());
		//OR
		sheet.createRow(i).createCell(0).setCellValue(allLinks.get(i).getAttribute("href"));
	}
	
	FileOutputStream fos = new FileOutputStream("./src/test/resources/PrintAllLinks.xlsx");
	workbook.write(fos);
	workbook.close();
	
}
}






