
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.io.PrintWriter;
import java.io.IOException;


public class Test {
	static DataSource dataSource = null;
	public static void main(String[] args){
		

		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/myDB");
		}catch (NamingException e){
			e.printStackTrace();
		}

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ID FROM USERS");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		stmt.close();
		conn.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}