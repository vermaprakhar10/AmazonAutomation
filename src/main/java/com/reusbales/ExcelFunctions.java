package main.java.com.reusbales;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFunctions {

	public ExcelFunctions() throws Exception {

	}

	public static void writeExcel(String filePath, String sheetName, String[] dataToWrite)
			throws Exception {
		if(filePath.equals("")) {
			filePath=System.getProperty("user.dir")+"\\src\\main\\resources\\TestResults.xlsx";
		}
		
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workBook = new XSSFWorkbook(inputStream);
		Sheet sheet = workBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		Row newRow = sheet.createRow(rowCount+1);
		
		for(int i=0;i<dataToWrite.length;i++) {
			 Cell cell = newRow.createCell(i);
		     cell.setCellValue(dataToWrite[i]);
		}
		

		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		workBook.write(outputStream);
		workBook.close();
		outputStream.close();

	}


}
