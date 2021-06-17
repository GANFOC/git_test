package testcases.CWE488_Exposure_of_Data_Element_to_Wrong_Session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CWE488_Exposure_of_Data_Element_to_Wrong_Session__servlet_getparameter_bad01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String data;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramName = "name";
		
		// FLAW
		data = request.getParameter(paramName);
		
		if (data != null) {
			response.getWriter().println("data: " + data);
		}
	}
}
