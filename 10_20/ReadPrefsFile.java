public class ReadPrefsFile {
	public static ArrayList<Prefs> readPrefs() {
		List<Prefs> pr = new ArrayList<>();
		FileReader reader = new FileReader("prefs.csv");
		BufferedReader buffer = new BufferedReader(reader);

		String line = "";

		while (true) {
			try {
				line = buffer.readLine();

			}catch (IOException e){
				e.printStackTrace();
			}
			if (line == null ){
				break;
			}
			String[] str = line.split(",");

			for(String a : str) {
				
			}


		}


	}
}