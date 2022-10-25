
import java.sql.*;
import java.util.*;


public class PrefsMain {
	public static void main(String[] args) {
		//Prefs prefs = new Prefs("d","n","c","bb",5);

		//System.out.println(prefs);
		ReadPrefsFile read = new ReadPrefsFile();
		ArrayList<Prefs> prefsList = new ArrayList<Prefs>();

		prefsList = read.readPrefs();

		// System.out.println(prefsList.get(0));

		PrefsDAO dao = new PrefsDAO();
		// System.out.println(dao.insertPrefs(prefsList));
		// dao.clearTable("prefs");

		// ArrayList<Prefs> list = dao.selectAllFrom("prefs");
		// System.out.println(list.toString());

		ResultSet rs = dao.selectAllFrom("prefs");
		// DBTablePrinter dbPrinter;
		DBTablePrinter.printResultSet(rs);
	

	}
}