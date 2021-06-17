package testcases.CWE674_Uncontrolled_Recursion;

import testcasesupport.*;

import java.io.BufferedReader;
import java.io.IOException;

import java.util.logging.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;

import java.util.logging.Logger;

public class CWE674_Uncontrolled_Recursion__connect_tcp_2_recursion_0101_bad extends AbstractTestCase
{
	private static long recursion_bad(long n)
    {
    	if (n < Long.MAX_VALUE)
    	{
    		/* FLAW: Missing base case */
    		long ret = n + recursion_bad(n-1);
    		return ret;
    	}
    	else
    	{
    		IO.writeLine("Input value is too large to perform.");
    		return 0;
    	}
    }

    public void bad() throws Throwable

    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        Socket sock = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* Read data using an outbound tcp connection */
            sock = new Socket("192.168.0.100", 9000);

            /* read input from socket */
            instrread = new InputStreamReader(sock.getInputStream(), "UTF-8");
            buffread = new BufferedReader(instrread);

            data = buffread.readLine();
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        finally {
        	/* clean up stream reading objects */
        	try {
        		if( buffread != null )
        		{
        			buffread.close();
        		}
        	}
        	catch( IOException ioe )
        	{
        		IO.logger.log(Level.WARNING, "Error closing BufferedReader", ioe);
        	}

        	try {
        		if( instrread != null )
        		{
        			instrread.close();
        		}
        	}
        	catch( IOException ioe )
        	{
        		IO.logger.log(Level.WARNING, "Error closing InputStreamReader", ioe);
        	}

        	/* clean up socket objects */
        	try {
        		if( sock != null )
        		{
        			sock.close();
        		}
        	}
        	catch( IOException e )
        	{
        		IO.logger.log(Level.WARNING, "Error closing Socket", e);
        	}
        }

        System.out.println(recursion_bad(Integer.parseInt(data)));


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
	public void good() throws Throwable {
		// TODO Auto-generated method stub
		
	}
}

