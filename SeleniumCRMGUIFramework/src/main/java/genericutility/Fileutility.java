package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Fileutility {
	public String getDataFromProp(String key) throws IOException {
	     FileInputStream fis= new FileInputStream("./configAppData/commondata.properties");
	     Properties poj= new Properties();
	     poj.load(fis);
	     String value=poj.getProperty(key);
	     return value;
	}
		
		
		} 



