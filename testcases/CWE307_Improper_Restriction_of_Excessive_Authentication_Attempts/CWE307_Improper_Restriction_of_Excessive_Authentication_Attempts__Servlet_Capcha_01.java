package testcases.CWE307_Improper_Restriction_of_Excessive_Authentication_Attempts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE307_Improper_Restriction_of_Excessive_Authentication_Attempts__Servlet_Capcha_01 extends AbstractTestCaseServlet {
	
	static class Authentication {
		public static boolean isAuthenticatedUser(String username, String password) {
			return true;
		}
	}
	
	final static int MAX_ATTEMPTS = 5;

	@Override
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String username = "user1";
		String password = "star1234";
		
		if (username == null || password == null || !Authentication.isAuthenticatedUser(username,password)) {
			response.getWriter().println("Invalid username, password<br/>");
			response.getWriter().println("<A href='blabla' Login Again</A></body></html>");
		} else {		
			response.getWriter().println(username + "has successfully logged in!");
		}
	}

	@Override
	public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		good_01(request, response);
		good_02(request, response);
	}

	private void good_01(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String username = "user1";
		String password = "star1234";
		int count = 0;
		
		while (count < MAX_ATTEMPTS) {
			if (username == null || password == null || !Authentication.isAuthenticatedUser(username,password)) {
				response.getWriter().println("Invalid username, password<br/>");
				response.getWriter().println("<A href='blabla' Login Again</A></body></html>");
			} else {		
				response.getWriter().println(username + "has successfully logged in!");
			}
			count++;
		}
	}

	private void good_02(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String username = "user1";
		String password = "star1234";
		
		for (int i=0; i<MAX_ATTEMPTS; i++) {
			if (username == null || password == null || !Authentication.isAuthenticatedUser(username,password)) {
				response.getWriter().println("Invalid username, password<br/>");
				response.getWriter().println("<A href='blabla' Login Again</A></body></html>");
			} else {		
				response.getWriter().println(username + "has successfully logged in!");
			}
		}
	}
}
