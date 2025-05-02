package practicedatadriventestin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFronJsonFile {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// 1.parse json physical file into java object using jsonparse class
  JSONParser par = new JSONParser();
  Object obj=par.parse(new FileReader("C:\\Users\\Owner\\AppData\\Roaming\\Microsoft\\Windows\\Network Shortcuts\\ppt\\appCommonData.json"));
  //2.convert object of java into json object using downcasting
  JSONObject map=(JSONObject)obj;
  //3.get the value from json file
 System.out.println(map.get("url"));
 System.out.println(map.get("browser"));
 System.out.println(map.get("username"));
 System.out.println(map.get("password"));
 System.out.println(map.get("timeout"));
 
	}

}
