package testcases.CWE496_Public_Data_Assigned_to_Private_Array_Typed_Field;

import java.util.Arrays;

public class CWE496_Public_Data_Assigned_to_Private_Array_Typed_Field__good {
	
	private byte[] foo = null;
	
	public void setFoo_good1(byte[] foo) {
		byte[] tmp_array = new byte[foo.length];
		
		for (int i=0; i<foo.length; i++) {
			tmp_array[i] = foo[i];
		}
		this.foo = tmp_array;
	}
	
	public void setFoo_good2(byte[] foo) {
		this.foo = new byte[foo.length];
		System.arraycopy(foo, 0, this.foo, 0, foo.length);
	}
	
	public void setFoo_good3(byte[] foo) {
		this.foo = Arrays.copyOf(foo, foo.length);
	}
	
	public void setFoo_good4(byte[] foo) {
		this.foo = Arrays.copyOfRange(foo, 0, foo.length);
	}

}
