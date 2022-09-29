import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args)throws IOException{
		

		FileWriter fw;

		try {
		 	fw = new FileWriter("data.txt");
		 	fw.write("Hello");
		} catch (IOException e){
			e.printStackTrace();
		}

		fw.close();
	}
}