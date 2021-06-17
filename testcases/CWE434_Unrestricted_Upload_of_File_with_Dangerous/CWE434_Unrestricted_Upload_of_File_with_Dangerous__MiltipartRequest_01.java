package testcases.CWE434_Unrestricted_Upload_of_File_with_Dangerous;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import testcasesupport.AbstractTestCaseServlet;

public class CWE434_Unrestricted_Upload_of_File_with_Dangerous__MiltipartRequest_01 extends AbstractTestCaseServlet
{
	@Override
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		bad_01(request, response);
		bad_02(request, response);
	}
	
	private void bad_01(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String saveDirectory = "/home/app/upload";
		
		MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory);
		
		// FLAW
		String fileName = multipartRequest.getFilesystemName("filename");
		
		File file = new File(saveDirectory, fileName);
	}
	
	private void bad_02(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String saveDirectory = "/home/app/upload";
		
		MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory);
		
		// FLAW
		String fileName = multipartRequest.getOriginalFileName("filename");
		
		File file = new File(saveDirectory, fileName);
	}
	
	@Override
	public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		good_01(request, response);
		good_02(request, response);
	}
	
    private void good_01(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
    	String saveDirectory = "/home/app/upload";
		
		MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory);
		
		String fileName = multipartRequest.getFilesystemName("filename");
		
		// FIX
		if (!(fileName.endsWith(".doc") || fileName.endsWith(".xls"))) {
			response.getWriter().println("disallowd file extension!");
			response.sendError(400);
		}
		
		File file = new File(saveDirectory, fileName);
    }
    
    private void good_02(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
    	String saveDirectory = "/home/app/upload";
		
		MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory);
		
		String fileName = multipartRequest.getOriginalFileName("filename");
		
		// FIX
		if (!(fileName.endsWith(".doc") || fileName.endsWith(".xls"))) {
			response.getWriter().println("disallowd file extension!");
			response.sendError(400);
		}
		
		File file = new File(saveDirectory, fileName);
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
}

