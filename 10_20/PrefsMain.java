public class PrefsMain {
	public static void main(String[] args) {
		ReadPrefsFile read = new ReadPrefsFile();

		ArrayList<Prefs> readList = read.readPrefs();
		System.out.println(readList);
	}
}