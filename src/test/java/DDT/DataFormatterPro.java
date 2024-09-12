package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import GenericUtility.ExcelFileUtility;

public class DataFormatterPro {
public static void main(String[] args) throws IOException {
	
	
	FileInputStream fis = new FileInputStream("./testData/TestDataVtiger.xlsx");
	
	XSSFWorkbook workbook= new XSSFWorkbook(fis);
	
	XSSFSheet sheet = workbook.getSheet("Organization");
	
	XSSFCell data = sheet.getRow(1).getCell(1);
	
	DataFormatter format=new DataFormatter();
	String phone = format.formatCellValue(data);
	System.out.println(phone);
	
	
}
}
