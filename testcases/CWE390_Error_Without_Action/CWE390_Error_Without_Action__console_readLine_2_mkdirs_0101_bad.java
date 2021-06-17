package testcases.CWE390_Error_Without_Action;

import testcasesupport.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.File;
import java.lang.SecurityException;


import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Logger;

public class CWE390_Error_Without_Action__console_readLine_2_mkdirs_0101_bad extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        /* read user input from console with readLine*/
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            instrread = new InputStreamReader(System.in, "UTF-8");
            buffread = new BufferedReader(instrread);
            data = buffread.readLine();
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        FileInputStream fis = null;
        File dirs = null;
        if(data != null)
        { 
        	dirs= new File(data);
        }
        
        try
        {
        	fis = new FileInputStream(dirs);
        }
		catch(FileNotFoundException e)
        {
        	/* FLAW: do nothing if dirs cannot be created */
        }
        finally
        {
        	try
        	{
        		if(fis != null)
        		{
        			fis.close();
        		}
        	}
        	catch(IOException e)
        	{
        		IO.logger.log(Level.WARNING, "Error closing FileInputStream", e);
        	}
        }



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

