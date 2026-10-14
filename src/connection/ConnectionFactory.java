package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public static Connection RequestConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db?user=root&password=root");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
}
