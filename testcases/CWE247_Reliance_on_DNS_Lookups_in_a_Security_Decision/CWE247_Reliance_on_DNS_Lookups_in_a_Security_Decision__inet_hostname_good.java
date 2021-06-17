package testcases.CWE247_Reliance_on_DNS_Lookups_in_a_Security_Decision;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CWE247_Reliance_on_DNS_Lookups_in_a_Security_Decision__inet_hostname_good extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean trusted = false;
		
		String ip = req.getRemoteAddr();
		
		String trustedAddr = "127.0.0.1";
		
		// FIX
		if (ip.equals(trustedAddr)) {
			trusted = true;
		}
	}
}