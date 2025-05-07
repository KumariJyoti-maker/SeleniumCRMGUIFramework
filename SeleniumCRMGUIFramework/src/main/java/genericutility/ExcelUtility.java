package genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromXls(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis2= new FileInputStream("C:\\Users\\Owner\\git\\automation_tl\\SeleniumCRMGUIFramework\\configAppData\\otms test cases.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
	Sheet sq= wb.getSheet(sheetName);
	Row rw= sq.getRow(rowNum);
	Cell ce= rw.getCell(cellNum);
	return  ce.getStringCellValue();
}
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis2= new FileInputStream("C:\\Users\\Owner\\Desktop\\Java\\SeleniumCRMGUIFramework\\configAppData\\otms test cases.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		int rowCont=wb.getSheet(sheetName).getLastRowNum();
		return rowCont;
	}
	public void setDataFromXls(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis2= new FileInputStream("C:\\Users\\Owner\\Desktop\\Java\\SeleniumCRMGUIFramework\\configAppData\\otms test cases.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
	wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
	FileOutputStream fos= new FileOutputStream("./configAppData/otms test case.xlsx");
	wb.write(fos);
	wb.close();
	}
}