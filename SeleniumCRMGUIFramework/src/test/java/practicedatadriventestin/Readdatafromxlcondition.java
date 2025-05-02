package practicedatadriventestin;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readdatafromxlcondition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String data1="";
		String data2="";
		String data3="";
		
		String expecTedtestId="TC_02";
		boolean flag= false;
		FileInputStream fis = new FileInputStream("C:\\Users\\Owner\\AppData\\Roaming\\Microsoft\\Windows\\Network Shortcuts\\ppt\\otms test cases.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Otms smtc ");
		int lrn=sh.getLastRowNum();
		for(int i=0;i<=lrn;i++) {
			//String data="";
			try {
				String data=sh.getRow(i).getCell(0).toString();
			if(data.equals(expecTedtestId)) {
				
				System.out.println(data1=sh.getRow(i).getCell(1).toString());
				System.out.println(data2=sh.getRow(i).getCell(2).toString());
				System.out.println(data3=sh.getRow(i).getCell(3).toString());
				//flag=true;
			}
			}catch(Exception e) {}
		}
			
			if(flag){
				System.out.println("match is found");
				
			}else {
			System.out.println("data is not available");
			}
		
		wb.close();
		
	}
	}

	


