import java.util.Date;

public class Simple2 {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.getTime());
		System.out.println(System.currentTimeMillis());

		Date past = new Date(1600705425827L);
		System.out.println(past);
	}
}