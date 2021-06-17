package testcases.CWE494_Download_of_Code_Without_Integrity_Check;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

import testcasesupport.AbstractTestCase;

public class CWE494_Download_of_Code_Without_Integrity_Check__urlclassloader_01 extends AbstractTestCase {

	@Override
	public void bad() throws Throwable {
		
		URL[] classURLs = new URL[]{
				new URL("file:subdir/")
		};

		URLClassLoader loader = new URLClassLoader(classURLs);
		
		// FLAW
		Class loadedClass = Class.forName("LoadMe", true, loader);
		
	}

	@Override
	public void good() throws Throwable {
		URL[] classURLs = new URL[]{
				new URL("file:subdir/")
		};

		URLClassLoader loader = new URLClassLoader(classURLs);
		Class loadedClass = Class.forName("LoadMe", true, loader);

		if(getChecksum(loadedClass) == isChecksum(loadedClass)) {
			try {
				Class lib = (Class) loadedClass.newInstance();
			} catch (InstantiationException e) {
				System.out.println("오류처리");
			} catch (IllegalAccessException e) {
				System.out.println("오류처리");
			}
		}	
	}
	
	private Object isChecksum(Class loadedClass) {
		return null;
	}

	private Object getChecksum(Class loadedClass) {
		return null;
	}
}
