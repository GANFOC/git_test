package testcases.CWE732_Incorrect_Permission_Assignment_for_Critical_Resource;

import java.io.File;

import testcasesupport.AbstractTestCase;

public class CWE732_Incorrect_Permission_Assignment_for_Critical_Resource__File_Permission_01 extends AbstractTestCase {

	@Override
	public void bad() throws Throwable {
		bad_01();
		bad_02();
	}
	
	public void bad_01() throws Throwable {
		File file = new File("/home/app/narthom.conf");
		
		// FLAW
		file.setExecutable(true);
		
		// FLAW
		file.setWritable(true);
				
		file.setReadable(true);
	}
	
	public void bad_02() throws Throwable {
		File file = new File("/home/app/narthom.conf");
		
		// FLAW
		file.setExecutable(true, false);
		
		// FLAW
		file.setWritable(true, false);
		
		// FLAW
		file.setReadable(true, false);
	}

	@Override
	public void good() throws Throwable {
		good_01();
		good_02();
	}
	
	public void good_01() throws Throwable {
		File file = new File("/home/app/narthom.conf");
		
		// FIX
		file.setExecutable(false);
		
		// FIX
		file.setWritable(false);
				
		file.setReadable(true);
	}
	
	public void good_02() throws Throwable {
		File file = new File("/home/app/narthom.conf");
		
		// FIX
		file.setExecutable(false, false);
		
		// FIX
		file.setWritable(false, false);
		
		// FIX
		file.setReadable(false, false);
	}
}