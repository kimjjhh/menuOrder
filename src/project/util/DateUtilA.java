package project.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtilA {
//	public static Date convertToDate(String strdate) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm");
//		java.util.Date d = null;
//		Date d2 = null;
//		try {
//			d = sdf.parse(strdate);
//			d2 = new Date(d.getTime());
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return d2;
//	}

	public static Date convertToDate2(String strdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		java.util.Date d = null;
		Date d2 = null;
		try {
			d = sdf.parse(strdate);
			d2 = new Date(d.getTime());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d2;
	}
	
}
