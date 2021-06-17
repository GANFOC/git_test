package testcases.CWE807_Reliance_on_Untrusted_Inputs_in_a_Security_Decision;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import testcasesupport.AbstractTestCaseServlet;

public class CWE807_Reliance_on_Untrusted_Inputs_in_a_Security_Decision__Servlet_Authenticated_Equals_01 extends AbstractTestCaseServlet {
	
	@Override
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		bad_01(request, response);
		bad_02(request, response);
	}
	
	public void bad_01(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Cookie [] cookies = request.getCookies(); 	
    	boolean authenticated = false;
    	
    	for(int i=0; i<cookies.length; i++)
    	{
    		Cookie c = cookies[i];
    		
    		// FLAW
    		if(c.getName().equals("authenticated") && Boolean.TRUE.equals(Boolean.valueOf(c.getValue())))
    		{
    			authenticated = true;
    		}
    	}
    	
    	if(authenticated)
    	{
    		System.out.println("login ok");
    	}
	}
	
	public void bad_02(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Cookie [] cookies = request.getCookies(); 	
    	boolean authenticated = false;
    	
    	for(int i=0; i<cookies.length; i++)
    	{
    		Cookie c = cookies[i];
    		
    		// FLAW
    		if(c.getName().equals("authenticated") && c.getValue().equalsIgnoreCase("true"))
    		{
    			authenticated = true;
    		}
    	}
    	
    	if(authenticated)
    	{
    		System.out.println("login ok");
    	}
	}

	@Override
	public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession c = request.getSession();
    	boolean authenticated = false;    	   
		
		if(Boolean.TRUE.equals(c.getAttribute("authenticated")))
		{
			authenticated = true;
		}
		
		if(authenticated)
    	{
    		System.out.println("login ok");
    	}
	}
}
