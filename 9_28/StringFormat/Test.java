public class Test {
	public static void main(String[] args) {
		final String FORMAT = "%-9s %-13s 所持金%,6d";
		String s = String.format(FORMAT,"vanthong1234","xxxxxxxxxxxxx",123456);
		System.out.println(s);
	}
}