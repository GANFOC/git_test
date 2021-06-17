package testcases.CWE497_Exposure_of_System_Data_to_an_Unauthorized_Control_Sphere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CWE497_Exposure_of_System_Data_to_an_Unauthorized_Control_Sphere__print_of_exception_msg_bad {
	
	public void bad() {
		Connection connection = null;
		String url = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url);
			connection.close();
		} catch (ClassNotFoundException e) {
			// FLAW
			System.err.printf(e.getMessage());
		} catch (SQLException e) {
			// FLAW
			System.err.println(e.getMessage());
		}
	}
}