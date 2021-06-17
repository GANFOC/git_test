/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE526_Info_Exposure_Environment_Variables__Servlet_01.java
Label Definition File: CWE526_Info_Exposure_Environment_Variables.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 526 Information Exposure Through Environment Variables
* Sinks: Servlet
*    GoodSink: no exposing
*    BadSink : expose the path variable to the user
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE754_Improper_Check_for_Unusual_or_Exceptional_Conditions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import testcasesupport.AbstractTestCase;

public class CWE754_Improper_Check_for_Unusual_or_Exceptional_Conditions__bad extends AbstractTestCase {
	
	@Override
	public void bad() throws Throwable {
		BufferedReader reader = null;
		
		try {
			URL url = new URL("http://jbline.co.kr");
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = reader.readLine();
			SimpleDateFormat format = new SimpleDateFormat("MM/DD/YY");
			Date date = format.parse(line);
		} catch (Exception e) { // FLAW
			System.err.println("Exception: " + e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ioe) {
					System.err.println("IOException: " + ioe.getMessage());
				}
			}
		}
	}

	@Override
	public void good()  {
		BufferedReader reader = null;
		
		try {
			URL url = new URL("http://jbline.co.kr");
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = reader.readLine();
			SimpleDateFormat format = new SimpleDateFormat("MM/DD/YY");
			Date date = format.parse(line);
		} catch (MalformedURLException e) { // FIX
			System.err.println("MalformedURLException: " + e.getMessage());
		} catch (IOException e) { // FIX
			System.err.println("IOException: " + e.getMessage());
		} catch (ParseException e) { // FIX
			System.err.println("ParseException: " + e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ioe) {
					System.err.println("IOException: " + ioe.getMessage());
				}
			}
		}
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