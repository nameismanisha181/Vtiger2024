import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadMultipleDataFromExcel {
public static void main(String[] args) throws IOException {
	
	FileInputStream fis = new FileInputStream("./src/test/resources/Links.xlsx");
	
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
	XSSFSheet sheet = workbook.getSheet("Sheet1");
	
	int count = sheet.getLastRowNum();
	
	for(int i=1;i<=count;i++)
	{
		String data = sheet.getRow(i).getCell(0).getStringCellValue();
		System.out.println(data);
	}
}
}
