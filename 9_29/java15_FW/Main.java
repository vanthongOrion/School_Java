import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args)throws IOException{
		

		FileWriter fw = new FileWriter("data.txt") ;

		try {
		 	fw = new FileWriter("data.txt");
		 	fw.write("Hello Thong");
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try{
				fw.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}

	}
}