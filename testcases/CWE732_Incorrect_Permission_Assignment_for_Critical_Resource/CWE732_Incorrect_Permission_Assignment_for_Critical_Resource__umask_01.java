package testcases.CWE732_Incorrect_Permission_Assignment_for_Critical_Resource;

import java.io.IOException;

import testcasesupport.AbstractTestCase;

public class CWE732_Incorrect_Permission_Assignment_for_Critical_Resource__umask_01 extends AbstractTestCase {

	@Override
	public void bad() throws Throwable {
		String yyy = "asdasdasdasd";
		
		String cmd = "umask 0";
		
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			System.out.println("시스템 명령 실행 오류");
		}
	}

	@Override
	public void good() throws Throwable {
		String cmd = "umask 77";
		
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			System.out.println("시스템 명령 실행 오류");
		}
	}
}