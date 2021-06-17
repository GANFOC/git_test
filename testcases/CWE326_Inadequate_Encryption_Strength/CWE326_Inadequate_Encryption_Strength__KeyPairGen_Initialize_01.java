package testcases.CWE326_Inadequate_Encryption_Strength;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

import testcasesupport.AbstractTestCase;

public class CWE326_Inadequate_Encryption_Strength__KeyPairGen_Initialize_01 extends AbstractTestCase {

	@Override
	public void bad() throws Throwable {
		bad_01();
		bad_02();
	}
	
	private void bad_01() throws Throwable {
		KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
		
		// FLAW
		kpGen.initialize(512);
		KeyPair pair = kpGen.generateKeyPair();
	}
	
	private void bad_02() throws Throwable {
		KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
		
		// FLAW
		kpGen.initialize(1024);
		KeyPair pair = kpGen.generateKeyPair();
	}

	@Override
	public void good() throws Throwable {
		KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
		
		// FIX
		kpGen.initialize(2048);
		KeyPair pair = kpGen.generateKeyPair();
	}
}
