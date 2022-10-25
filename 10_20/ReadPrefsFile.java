import java.util.*;
import java.io.*;


public class ReadPrefsFile {
	public static void main(String[] args){
		readPrefs();
	}
	public static ArrayList<Prefs> readPrefs() {

		ArrayList<Prefs> pr = new ArrayList<Prefs>();
		FileReader read;
		String line = "";

		try {
			read = new FileReader("prefs.csv");
			BufferedReader buffer = new BufferedReader(read);

			while(true){
				try {
					line = buffer.readLine();

				}catch (IOException e){
					e.printStackTrace();
				}
				if (line==null){
					break;
				}
				String[] arrOfStr = line.split(",");
				pr.add(new Prefs(arrOfStr[0],arrOfStr[1],arrOfStr[2],arrOfStr[3],Integer.parseInt(arrOfStr[4])));
			}

			return pr;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	
	}

}