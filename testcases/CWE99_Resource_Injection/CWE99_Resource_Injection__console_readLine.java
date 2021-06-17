package testcases.CWE99_Resource_Injection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testcasesupport.AbstractTestCaseServlet;
import testcasesupport.IO;

public class CWE99_Resource_Injection__console_readLine extends AbstractTestCaseServlet {

	@Override
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String data = "";
		
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
		
		int port = 19000;

		Socket clientSock = null;
		try {
			// FLAW
			clientSock = new Socket(data, port);
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if(clientSock != null) {
				try {
					clientSock.close();
				} catch(Exception e) {
				}
			}
		}
	}

	@Override
	public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

	}


}
