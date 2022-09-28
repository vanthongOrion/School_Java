import java.util.*;

public class Main {
	public static void main(String[] args){
		Map<String, Integer> prefs = new HashMap<>();

		prefs.put("kyotofu",1000);
		prefs.put("saitama",500);
		prefs.put("tochigi",7000);

		System.out.println("京都の口は" + prefs.get("kyotofu"));

	}
}