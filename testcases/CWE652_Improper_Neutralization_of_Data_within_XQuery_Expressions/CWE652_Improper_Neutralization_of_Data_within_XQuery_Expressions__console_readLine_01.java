/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Xpath_Injection__getParameter_Servlet_01.java
Label Definition File: CWE643_Xpath_Injection.label.xml
Template File: sources-sinks-01.tmpl.java
*/
/*
* @description
* CWE: 643 Xpath Injection
* BadSource: getParameter_Servlet Read data from a querystring using getParameter()
* GoodSource: A hardcoded string
* Sinks:
*    GoodSink: validate input through StringEscapeUtils
*    BadSink : user input is used without validate
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE652_Improper_Neutralization_of_Data_within_XQuery_Expressions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import net.xqj.basex.BaseXXQDataSource;
import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE652_Improper_Neutralization_of_Data_within_XQuery_Expressions__console_readLine_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
    	String data;

        data = ""; /* Initialize data */

        {
            InputStreamReader readerInputStream = null;
            BufferedReader readerBuffered = null;

            /* read user input from console with readLine */
            try
            {
                readerInputStream = new InputStreamReader(System.in, "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);

                /* POTENTIAL FLAW: Read data from the console using readLine */
                data = readerBuffered.readLine();
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
                try
                {
                    if (readerBuffered != null)
                    {
                        readerBuffered.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                }

                try
                {
                    if (readerInputStream != null)
                    {
                        readerInputStream.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                }
            }
        }
        /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */
        
        if (data != null)
        {
        	String es = "doc('event.xml')/winnerlist/entry[id='" + data + "']";
        	
        	XQDataSource ds = new BaseXXQDataSource();
    		XQConnection conn = null;
    		XQPreparedExpression expr = null;
    		XQResultSequence result = null;
    		
    		try {
    			conn = ds.getConnection();
    			expr = conn.prepareExpression(es);
    			// FLAW
    			result = expr.executeQuery(); 
    			
    			if(result.next()) {
    				result.getAtomicValue();
    			}
    		} catch (XQException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} finally {
    			if(result != null) try { result.close(); } catch(Exception e) {}
    			if(expr != null) try { expr.close(); } catch(Exception e) {}
    			if(conn != null) try { conn.close(); } catch(Exception e) {}
    		}
        }
    }

    public void good() throws Throwable
    {
    	String data;

        data = ""; /* Initialize data */

        {
            InputStreamReader readerInputStream = null;
            BufferedReader readerBuffered = null;

            /* read user input from console with readLine */
            try
            {
                readerInputStream = new InputStreamReader(System.in, "UTF-8");
                readerBuffered = new BufferedReader(readerInputStream);

                /* POTENTIAL FLAW: Read data from the console using readLine */
                data = readerBuffered.readLine();
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
                try
                {
                    if (readerBuffered != null)
                    {
                        readerBuffered.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                }

                try
                {
                    if (readerInputStream != null)
                    {
                        readerInputStream.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                }
            }
        }
        /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */

        if (data != null)
        {
        	String es = "doc('event.xml')/winnerlist/entry[id='$xid']";
        	
        	XQDataSource ds = new BaseXXQDataSource();
    		XQConnection conn = null;
    		XQPreparedExpression expr = null;
    		XQResultSequence result = null;
    		
    		try {
    			conn = ds.getConnection();
    			// FIX
    			expr = conn.prepareExpression(es);
    			expr.bindString(new QName("xid"), data, null);
    			result = expr.executeQuery(); 
    			
    			if(result.next()) {
    				result.getAtomicValue();
    			}
    		} catch (XQException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} finally {
    			if(result != null) try { result.close(); } catch(Exception e) {}
    			if(expr != null) try { expr.close(); } catch(Exception e) {}
    			if(conn != null) try { conn.close(); } catch(Exception e) {}
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

