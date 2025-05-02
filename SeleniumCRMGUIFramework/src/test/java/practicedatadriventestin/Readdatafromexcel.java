package practicedatadriventestin;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readdatafromexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Owner\\AppData\\Roaming\\Microsoft\\Windows\\Network Shortcuts\\ppt\\otms test cases.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Otms smtc ");
		int lrn=sh.getLastRowNum();
		for(int i=1;i<=lrn;i++) {
			
			Row rw=sh.getRow(i);
			
			String data1=rw.getCell(0).toString();
			String data2=rw.getCell(1).toString();
			
			
			System.out.println(data1	+"\t"	+ data2);
		}
		wb.close();
		
	}

}
