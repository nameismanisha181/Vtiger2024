package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteDataIntoExcelFile {
public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.saucedemo.com/");	
	
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	
	//driver.switchTo().alert().accept();	
	String title = driver.getTitle();
	System.out.println(title);
	//step1: give connection between physical file and test script
	FileInputStream fis= new FileInputStream("./src/test/resources/Login.xlsx");
	
	//step2: keep excel file in read mode
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	
	//step3: taking control of excel sheet 
	XSSFSheet sheet1 = workbook.getSheet("Sheet1");
	
	//step4: taking control of row
	XSSFRow row = sheet1.createRow(3);
	
	//step5 taking control of cell
	XSSFCell cel = row.createCell(2);
	
	cel.setCellValue(title);
	//step6 
	FileOutputStream fos = new FileOutputStream("./src/test/resources/Login.xlsx");
	
	workbook.write(fos);
	workbook.close();	
}
}
