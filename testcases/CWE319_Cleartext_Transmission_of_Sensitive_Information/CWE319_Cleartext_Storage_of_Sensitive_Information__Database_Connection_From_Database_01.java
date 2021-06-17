package testcases.CWE319_Cleartext_Transmission_of_Sensitive_Information;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE319_Cleartext_Storage_of_Sensitive_Information__Database_Connection_From_Database_01 extends AbstractTestCase {

	@Override
	public void bad() throws Throwable {
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		String data = "";
		
		try {
			
			con = IO.getDBConnection();
			
			statement = con.prepareStatement("select name from users where id=0");
			rs = statement.executeQuery();
			rs.next();
			
			data = rs.getString(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Connection con2 = null;
		Logger log2 = Logger.getLogger("local-logger");
		
		try {
			// FLAW
			con2 = DriverManager.getConnection("192.168.105.23", "sa", data);
		} catch (SQLException se) {
			log2.warning("error getting database connection");
		}
	}

	@Override
	public void good() throws Throwable {
		// TODO Auto-generated method stub
		
	}
	

}
