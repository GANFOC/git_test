package testcases.CWE676_Use_of_Potentially_Dangerous_Function;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CWE676_Use_of_Potentially_Dangerous_Function__drivermanager_in_servlet_good extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final String CONNECT_STRING = "jdbc:ocl:orcl";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			createConnection();
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
	}
	
	private Connection createConnection() throws SQLException, NamingException {
		InitialContext ctx = new InitialContext();
		DataSource dataSource = (DataSource) ctx.lookup(CONNECT_STRING);
		
		// FIX
		Connection connection = dataSource.getConnection();
		return connection;
	}
}