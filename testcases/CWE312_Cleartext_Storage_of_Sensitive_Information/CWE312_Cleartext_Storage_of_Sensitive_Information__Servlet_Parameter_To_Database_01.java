package testcases.CWE312_Cleartext_Storage_of_Sensitive_Information;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;
import testcasesupport.IO;

public class CWE312_Cleartext_Storage_of_Sensitive_Information__Servlet_Parameter_To_Database_01 extends AbstractTestCaseServlet {

	@Override
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		
		String sql = "insert into customer(id, pwd, name, ssn, zipcode, addr)"
				+ " values(?,?,?,?,?,?)";
		
		Connection connection = null;
		PreparedStatement pstmt = null;
				
		try {
			connection = IO.getDBConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			
			// FLAW
			pstmt.setString(2, pwd);
			pstmt.setString(3, "");
			pstmt.setString(4, "");
			pstmt.setString(5, "");
			pstmt.setString(6, "");
			
			pstmt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		final String salt = "^%&*#$";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.update(salt.getBytes());
		pwd = new String(digest.digest(pwd.getBytes()));
		
		String sql = "insert into customer(id, pwd, name, ssn, zipcode, addr)"
				+ " values(?,?,?,?,?,?)";
		
		Connection connection = null;
		PreparedStatement pstmt = null;
				
		try {
			connection = IO.getDBConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			
			// FIX
			pstmt.setString(2, pwd);
			pstmt.setString(3, "");
			pstmt.setString(4, "");
			pstmt.setString(5, "");
			pstmt.setString(6, "");
			
			pstmt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
	}
}
