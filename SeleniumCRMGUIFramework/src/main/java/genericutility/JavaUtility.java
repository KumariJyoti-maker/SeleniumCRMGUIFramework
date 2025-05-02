package genericutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNum() {
		Random ran=new Random();
		int ranno=ran.nextInt(20000);
		return ranno;
		
	}
public String getSystemDate() {
	Date dat= new Date();
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
	String date= sdf.format(dat);
	return date;
}
}
