package testcases.CWE521_Weak_Password_Requirements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE521_Weak_Password_Requirements__database_getConnection_from_getParameter_01 extends AbstractTestCaseServlet {

	@Override
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "orcl";
		String password = request.getParameter("dbpasswd");
		
		Connection connection = null;
		try {
			// FLAW
			connection = DriverManager.getConnection(url, user, password);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
		}
	}

	@Override
	public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "orcl";
		String password = "orcl1289!@";
		
		Connection connection = null;
		try {
			// FIX
			connection = DriverManager.getConnection(url, user, password);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
		}
	}
}
