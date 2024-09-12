package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchDataFromExcelUsinDataFormatter {
public static void main(String[] args) throws IOException {
	
	//step1
	FileInputStream fis= new FileInputStream("./src/test/resources/DataFormatter.xlsx");
	
	//step2
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	
	//step3
	XSSFSheet sheet = workbook.getSheet("Sheet1");
	
	//step4
	XSSFRow row = sheet.getRow(2);
	
	//step5
	XSSFCell cell = row.getCell(0);
	
	//will get exception if trying to fetch numeric value as cell.getStringcellValue()
	//will get exception for this
	//System.out.println(cell.getStringCellValue());
	
	DataFormatter format= new DataFormatter();
	String data = format.formatCellValue(cell);
	System.out.println(data);
}
}
