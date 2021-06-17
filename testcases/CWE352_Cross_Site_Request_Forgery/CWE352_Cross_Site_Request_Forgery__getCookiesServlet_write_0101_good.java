package testcases.CWE352_Cross_Site_Request_Forgery;

import testcasesupport.*;

import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.logging.Logger;

public class CWE352_Cross_Site_Request_Forgery__getCookiesServlet_write_0101_good extends AbstractTestCaseServlet
{


    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        goodB2G(request, response);
    }

    
    
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* initialize data in case there are no cookies */

        /* Read data from cookies */
        {
            Cookie cookieSources[] = request.getCookies();
            if (cookieSources != null)
            {
                
                data = cookieSources[0].getValue();
            }
        }
		
        /* Assuming the presence of a session variable called "token" that contains
             * the nonce value to prevent CSRF */
        /* This testcase is dependent on several others to be a valid weakness:
         *	346 - Origin Validation Error
         *	441 - Unintended Proxy/Intermediary
         *	613 - Insufficient Session Expiration */

        HttpSession session = request.getSession(true);
        String trustedToken = session.getAttribute("token").toString();

        /* FIX: test the value of the request's "token" vs. the session "token" */
        if( request.getParameter("token") == null ||
                !request.getParameter("token").equals(trustedToken) )
        {
            return;
        }

        response.getWriter().write(data);

    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }



	@Override
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
	}
}

