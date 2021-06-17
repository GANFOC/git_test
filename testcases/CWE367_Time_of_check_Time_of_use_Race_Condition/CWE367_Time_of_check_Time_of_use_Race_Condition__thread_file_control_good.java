/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE338_Weak_PRNG__math_01.java
Label Definition File: CWE338_Weak_PRNG.label.xml
Template File: point-flaw-01.tmpl.java
 */
/*
 * @description
 * CWE: 338 Use of Cryptographically Weak PRNG
 * Sinks: math
 *    GoodSink: stronger PRNG
 *    BadSink : weak PRNG
 * Flow Variant: 01 Baseline
 *
 * */

package testcases.CWE367_Time_of_check_Time_of_use_Race_Condition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CWE367_Time_of_check_Time_of_use_Race_Condition__thread_file_control_good extends Thread 
{
	private static final String SYNC = "SYNC";
	
	private String manageType = "";
	
	public CWE367_Time_of_check_Time_of_use_Race_Condition__thread_file_control_good(String manageType) {
		this.manageType = manageType;
	}
	
	@Override
	public void run() {
		synchronized (SYNC) {
			try {
				if (manageType.equals("READ")) {
					File f = new File("Test_367.txt");
					if (f.exists()) {
						BufferedReader br = new BufferedReader(new FileReader(f));
						br.close();
					}
				} else if (manageType.equals("DELETE")) {
					File f = new File("Test_367.txt");
					if (f.exists()) {
						f.delete();
					} else { }
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

