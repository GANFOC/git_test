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

import java.nio.charset.Charset;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;

public class CWE615_Info_Exposure_by_Comment__encryption extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        /* FLAW */
    	// dbsample : 84d5d0a08a3ec5e2d91a
    	// 암호화 전, 후 : 1365ADMIN_01, aa84c40031d808196537ad3dcf81f9af
    	String pwd = "aa84c40031d808196537ad3dcf81f9af";
    	String pwd1 = Base64.getEncoder().encode(pwd.getBytes(Charset.defaultCharset())).toString();
    	System.out.println(pwd1);
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

