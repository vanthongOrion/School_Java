package mondai;


import java.text.*;
import java.util.Date;

public class SetUpDate {
	public Date setDate(String format,String dateText){
		try{
			SimpleDateFormat sdformat = new SimpleDateFormat(format);
			Date result;
			return sdformat.parse(dateText);
		}catch(ParseException e){
			e.printStackTrace();
			return null;
		}
	}
}