
import java.util.*;
import java.sql.*;

public class PrefsDAO {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		//for mac use SSL false
		String url = "jdbc:mysql://localhost:3306/newDB?autoReconnect=true&useSSL=false";
		// for windows
		// String url = "jdbc:mysql://localhost:3306/newDB";
		Connection con = null;
		PreparedStatement prst;
		Statement st;
		ResultSet rs;

	public int insertPrefs(ArrayList<Prefs> prefs) {
		int count = 0;

		try {
			con = DriverManager.getConnection(url,"root","root");
			String query = "Insert into Prefs values(?,?,?,?,?)";
			
			for(Prefs pr: prefs) {
				try {
					prst = con.prepareStatement(query);
					prst.setString(1,pr.getCode());
					prst.setString(2,pr.getRegion());
					prst.setString(3,pr.getPrefName());
					prst.setString(4,pr.getPrefCapital());
					prst.setInt(5,pr.getArea());

					count += prst.executeUpdate();
				}catch (SQLException e) {
					e.printStackTrace();
				}	
			}

			return count;
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int clearTable(String nameOfTable) {
		try{
			con = DriverManager.getConnection(url,"root","root");
			String query = "DELETE FROM " + nameOfTable;
			st = con.createStatement();
			return st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return -0;
		}
	}

	// public ArrayList<Prefs> selectAllFrom(String nameOfTable) {
	// 	ArrayList<Prefs> prefsList = new ArrayList<Prefs>();
	// 	try{
	// 		con = DriverManager.getConnection(url,"root","");
	// 		String query = "SELECT * FROM " + nameOfTable;
	// 		st = con.createStatement();
	// 		rs = st.executeQuery(query);
	// 		while(rs.next()){
	// 			prefsList.add(new Prefs(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
	// 		}
	// 		return prefsList;
	// 	}catch (SQLException e) {
	// 		e.printStackTrace();
	// 		return null;
	// 	}
	// }

	public ResultSet selectAllFrom(String nameOfTable) {
		ResultSet rs;
		try{
			con = DriverManager.getConnection(url,"root","root");
			String query = "SELECT * FROM " + nameOfTable;
			st = con.createStatement();
			return rs = st.executeQuery(query);

		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ResultSet selectFromSuffix(String tableName, String columnName, String s) {
		try {
			con = DriverManager.getConnection(url,"root","root");
			String query = String.format("SELECT * FROM %1$s WHERE %2$s LIKE %3$s;",tableName,columnName,quote(s));
			st = con.createStatement();
			return rs = st.executeQuery(query);
		}catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	public static String quote(String s) {
	    return new StringBuilder()
	        .append('\'')
	        .append(s)
	        .append('\'')
	        .toString();
	}


}