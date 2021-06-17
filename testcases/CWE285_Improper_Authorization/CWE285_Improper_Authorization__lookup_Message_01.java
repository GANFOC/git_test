package testcases.CWE285_Improper_Authorization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE285_Improper_Authorization__lookup_Message_01 extends AbstractTestCaseServlet {

	@Override
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String msgId = request.getParameter("msgId");
		
		if (username == null || password == null || !Util.isAuthenticatedUser(username, password))
		{
			throw new Exception("Invalid username, password");
		}
		if (msgId == null)
		{
			throw new Exception("Invalid msgId");
		}
		
		Message msg = Util.LookupMessageObject(msgId);
		
		/* FLAW */
		if (msg != null) {
			response.getWriter().println("From: " + msg.getUserName());
			response.getWriter().println("Subject: " + msg.getSubField());
			response.getWriter().println("Body: " + msg.getBodyField());
		}
	}

	@Override
	public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		good_01(request, response);
		good_02(request, response);
	}
	
	public void good_01(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String data;

		data = "passwd";

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String msgId = request.getParameter("msgId");
		
		if (username == null || password == null || !Util.isAuthenticatedUser(username, password))
		{
			throw new Exception("Invalid username, password");
		}
		if (msgId == null)
		{
			throw new Exception("Invalid msgId");            
		}
		
		Message msg = Util.LookupMessageObject(msgId);
		
		/* FIX */
		if (msg != null && password.equals(data)) {
			response.getWriter().println("From: " + msg.getUserName());
			response.getWriter().println("Subject: " + msg.getSubField());
			response.getWriter().println("Body: " + msg.getBodyField());            
		}
	}
	
	public void good_02(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String msgId = request.getParameter("msgId");

		if (username == null || password == null || !Util.isAuthenticatedUser(username, password))
		{
			throw new Exception("Invalid username, password");
		}
		if (msgId == null)
		{
			throw new Exception("Invalid msgId");            
		}

		Message msg = Util.LookupMessageObject(msgId);

		/* FIX */
		if (msg != null && username.equals(msg.getUserName())) {
			response.getWriter().println("From: " + msg.getUserName());
			response.getWriter().println("Subject: " + msg.getSubField());
			response.getWriter().println("Body: " + msg.getBodyField());            
		}
	}
}
