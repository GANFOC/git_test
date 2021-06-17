package testcases.CWE676_Use_of_Potentially_Dangerous_Function;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CWE676_Use_of_Potentially_Dangerous_Function__drivermanager_in_servlet_bad extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			createConnection("", "", "");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	private Connection createConnection(String url, String user, String password) throws SQLException {
		// FLAW
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}