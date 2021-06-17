/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE615_Info_Exposure_by_Comment__Servlet_01.java
Label Definition File: CWE615_Info_Exposure_by_Comment__Servlet.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 615 Information Exposure by Comment
* Sinks:
*    GoodSink: no disclosure of username and password
*    BadSink : disclose username and password
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE615_Information_Exposure_Through_Comments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE615_Info_Exposure_by_Comment__jdbc_connection extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        /* FLAW */
		/* Password for administrator is "tiger."<-주석에 패스워드가 적혀있다. */
    	String url = "DBServer";
		String password = "tiger";
		Connection con = null;
		
		try
		{
		   con = DriverManager.getConnection(url, "scott", password);
		}
		catch (SQLException e)
		{System.out.println("오류");}
		finally{
			con.close();
		}
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        good1(request, response);
    }

    private void good1(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        

    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}

