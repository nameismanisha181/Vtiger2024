package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertMultilpleLinksIntoExcel {
public static void main(String[] args) throws IOException {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.in");
	
    FileInputStream fis = new FileInputStream("./src/test/resources/Links.xlsx");
	
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	
	XSSFSheet sheet1 = workbook.getSheet("Sheet1");
	
	List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
	
	for(int i=1;i<=allLinks.size()-1;i++)
	{
	
	XSSFRow row = sheet1.createRow(i);
	
	row.createCell(0).setCellValue(allLinks.get(i).getAttribute("href"));
	}
	FileOutputStream fos = new FileOutputStream("./src/test/resources/Links.xlsx");
	workbook.write(fos);
	workbook.close();
}
}
