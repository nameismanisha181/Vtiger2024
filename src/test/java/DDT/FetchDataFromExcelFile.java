package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromExcelFile {
public static void main(String[] args) throws IOException {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.saucedemo.com/");	
	
	FileInputStream fis= new FileInputStream("./src/test/resources/Login.xlsx");//step 1 
	XSSFWorkbook workbook = new XSSFWorkbook(fis);//step2 keeping excel file in reading mode	
	XSSFSheet sheet1 = workbook.getSheet("Sheet1");//read sheet name
	XSSFRow row = sheet1.getRow(1);//get row
	XSSFCell cell = row.getCell(0);//get column
	
	String USERNAME = cell.getStringCellValue();
	String PASSWORD = sheet1.getRow(1).getCell(1).getStringCellValue();
	
	WebElement username = driver.findElement(By.id("user-name"));
	WebElement password = driver.findElement(By.id("password"));
	username.sendKeys(USERNAME);
	password.sendKeys(PASSWORD);	
	
	System.out.println(USERNAME);
	System.out.println(PASSWORD);
	driver.findElement(By.id("login-button")).click();
}
}
