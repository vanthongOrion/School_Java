

public class PrefDAO {
	static 
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}catch (Exception e){
		e.printStackTrace();
	}

	public int insertPrefs(ArrayList<Prefs> prefs) {
		try {
			int i = 0;
			connection = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/test","root","admin");

			String query = "Insert into prefs values (?,?,?,?,?)";
			PreparedStatement prst =  connection.preparedStatement(query);

			for(Prefs pref : prefs){
				prst.setString(1,pref.getCode());
				prst.setString(2,pref.getRegion();
				prst.setString(3,pref.getPrefName()
				prst.setString(4,pref.getPrefCapital();
				prst.setString(5,pref.getArea();

				i += prst.executeUpdate();
			}
			connection.close();
			return i;

		}catch (Exception e){
			e.printStackTrace();
			return 0;
		}
	}



}