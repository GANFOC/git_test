package testcases.CWE488_Exposure_of_Data_Element_to_Wrong_Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE488_Exposure_of_Data_Element_to_Wrong_Session__servlet_getparameter_bad02 extends AbstractTestCaseServlet {
	private static final long serialVersionUID = 1L;
	
	private String data;
	
	@Override
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String paramName = "name";
		
		// FLAW
		data = request.getParameter(paramName);
		
		if (data != null) {
			response.getWriter().println("data: " + data);
		}
	}

	@Override
	public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
	}
}
