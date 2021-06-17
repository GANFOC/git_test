package testcases.CWE319_Cleartext_Transmission_of_Sensitive_Information;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import testcasesupport.AbstractTestCase;

public class CWE319_Cleartext_Storage_of_Sensitive_Information__Database_Connection_From_Console_01 extends AbstractTestCase {

	@Override
	public void bad() throws Throwable {
		InputStreamReader instrread = null;
		BufferedReader buffread = null;
		String data = "";
			
		try {
				
			instrread = new InputStreamReader(System.in, "UTF-8");
			buffread = new BufferedReader(instrread);			
			data = buffread.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		Logger log2 = Logger.getLogger("local-logger");
		
		try {
			// FLAW
			con = DriverManager.getConnection("192.168.105.23","sa", data);			
		} catch (SQLException se) {
			log2.warning("error getting database connection");
		}
	}

	@Override
	public void good() throws Throwable {
		// TODO Auto-generated method stub
		
	}
	

}
