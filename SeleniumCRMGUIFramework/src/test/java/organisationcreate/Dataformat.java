package organisationcreate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dataformat {

	public static void main(String[] args) {
	Date dat=new Date();
	SimpleDateFormat sdf= new SimpleDateFormat("YYYY-MM-dd");
	String acDate=sdf.format(dat);
	System.out.println(acDate);
	SimpleDateFormat sdf1= new SimpleDateFormat("YYYY-MM-dd");
	Calendar cal=Calendar.getInstance();
	cal.add(Calendar.DAY_OF_MONTH,30);
	String dateRequire=sdf1.format(cal.getTime());
	System.out.println(dateRequire);

	}

}
