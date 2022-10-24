import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadPrefsFile {
	public static void main(String[] args){
		readPrefs();
	}
	public static ArrayList<Prefs> readPrefs() {
		List<Prefs> pr = new ArrayList<>();
			FileReader reader;
		try {
			reader = new FileReader("prefs.csv");
			BufferedReader buffer = new BufferedReader(reader);
		}

		try(FileReader reader = new FileReader("prefs.csv");
			BufferedReader buffer = new BufferedReader(reader);
			String line = "";
			){
			// while (true) {
			// 	try {
			// 		line = buffer.readLine();

			// 	}catch (IOException e){
			// 		e.printStackTrace();
			// 	}
			// 	if (line == null ){
			// 		break;
			// 	}
			// 	String[] str = line.split(",");

			// 	pr.add(new Prefs(str[0],str[1],str[2],str[3],Integer.parseInt(4)));
				// return pr;
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
			return null;
	
}