package testcases.CWE496_Public_Data_Assigned_to_Private_Array_Typed_Field;

public class CWE496_Public_Data_Assigned_to_Private_Array_Typed_Field__bad {
	
	private byte[] foo = null;
	
	public void setFoo_bad1(byte[] foo) {
		// FLAW
		this.foo = foo;
	}
	
	public void setFoo_bad2(byte[] foo) {
		byte[] tmp_array = foo;
		// FLAW
		this.foo = tmp_array;
	}

}
