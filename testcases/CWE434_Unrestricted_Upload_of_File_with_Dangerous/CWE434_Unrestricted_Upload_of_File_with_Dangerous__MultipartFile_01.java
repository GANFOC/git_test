package testcases.CWE434_Unrestricted_Upload_of_File_with_Dangerous;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import testcasesupport.AbstractTestCaseServlet;

public class CWE434_Unrestricted_Upload_of_File_with_Dangerous__MultipartFile_01 extends AbstractTestCaseServlet
{
	@Override
	public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		bad_01(request, response);
	}

	private void bad_01(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String saveDirectory = "/home/app/upload";

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		MultipartFile multipartFile = multipartRequest.getFile("file");

		// FLAW
		String fileName = multipartFile.getOriginalFilename();

		File file = new File(saveDirectory, fileName);
	}

	private void bad_02(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String saveDirectory = "/home/app/upload";

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		MultipartFile multipartFile = multipartRequest.getFile("file");

		// FLAW
		String fileName = multipartFile.getName();

		File file = new File(saveDirectory, fileName);
	}

	public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
	{
		good_01(request, response);
		good_02(request, response);
	}

	private void good_01(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String saveDirectory = "/home/app/upload";

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		MultipartFile multipartFile = multipartRequest.getFile("file");

		String fileName = multipartFile.getOriginalFilename();
		
		// FIX
		if (!fileName.endsWith(".doc") || fileName.endsWith(".xls")) {
			return;
		}

		File file = new File(saveDirectory, fileName);
	}

	private void good_02(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String saveDirectory = "/home/app/upload";

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		MultipartFile multipartFile = multipartRequest.getFile("file");

		String fileName = multipartFile.getName();
		
		// FIX
		if (!fileName.endsWith(".doc") || fileName.endsWith(".xls")) {
			return;
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

