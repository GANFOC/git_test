package testcases.CWE807_Reliance_on_Untrusted_Inputs_in_a_Security_Decision;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import testcasesupport.AbstractTestCaseServlet;

public class CWE807_Reliance_on_Untrusted_Inputs_in_a_Security_Decision__Servlet_Basic_Equals_01 extends AbstractTestCaseServlet {
	
	@Override
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String userRole = "";
		
    	Cookie [] cookies = request.getCookies(); 	    	
    	
    	for(int i=0; i<cookies.length; i++)
    	{
    		Cookie c = cookies[i];
    		
    		if(c.getName().equals("role"))
    		{
    			// FLAW
    			userRole = c.getValue();
    		}
    	}
    	System.out.println("login ok " + userRole);
	}

	@Override
	public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession c = request.getSession();
    	String userRole = "";
    	userRole = (String)c.getAttribute("userRole");
		
		System.out.println("login ok " + userRole);
	}
}
