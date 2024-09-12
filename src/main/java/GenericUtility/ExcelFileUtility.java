package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtility {
/**
 * This method is used to read data from excel sheet
 * @param sheetName
 * @param row
 * @param cell
 * @return
 * @throws IOException
 */
	public String getDataFromExcel(String sheetName,int row,int cell) throws IOException
	{
		FileInputStream fis = new FileInputStream("./testData/TestDataVtiger.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		XSSFRow row1 = sheet.getRow(row);
		
		XSSFCell cell1 = row1.getCell(cell);
		
		String data = cell1.getStringCellValue();
		
		return data;		
	}
	
	/**
	 * This method is used to write data into excel
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName,int row,int cell,String data) throws IOException
	{
		FileInputStream fis = new FileInputStream("./testData/TestDataVtiger.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		sheet.getRow(row).getCell(cell).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream("./testData/TestDataVtiger.xlsx");
		workbook.write(fos);
		workbook.close();
	}
}
