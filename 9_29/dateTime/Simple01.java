import java.util.Calendar;
import java.util.Date;

public class Simple01 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();

		System.out.println("now :" + c.get(Calendar.MONTH));

		c.set(2019,8,22,1,23,45);
		c.set(Calendar.MONTH, 9);
		Date d = c.getTime();
		System.out.println(d);

		Date now = new Date();
		c.setTime(now);
		int y = c.get(Calendar.YEAR);
		System.out.println("This Year is " + y);

	}
}