package genericutility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDataFromJson(String key) throws IOException, ParseException {
		JSONParser par = new JSONParser();
		  Object obj=par.parse(new FileReader("C:\\Users\\Owner\\Desktop\\Java\\SeleniumCRMGUIFramework\\configAppData\\appCommonData.json"));
		  JSONObject map=(JSONObject)obj;
		 
		 String value=(String) map.get(key);
	    
	     return value;
	}

}
