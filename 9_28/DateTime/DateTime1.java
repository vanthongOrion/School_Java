public class DateTime1 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// System.out.println(start);

		long end = System.currentTimeMillis();
		// System.out.println(end);
		System.out.println("処理にかかった時間は・・・" + (end - start) + "ミリ秒でした。");
	}
}