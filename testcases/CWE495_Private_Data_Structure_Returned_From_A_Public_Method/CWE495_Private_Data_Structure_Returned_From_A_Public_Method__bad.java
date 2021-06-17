package testcases.CWE495_Private_Data_Structure_Returned_From_A_Public_Method;

public class CWE495_Private_Data_Structure_Returned_From_A_Public_Method__bad {
	
	private byte[] foo = null;
	
	public byte[] getFoo_bad1() {
		// FLAW
		return foo;
	}
	
	public byte[] getFoo_bad2() {
		byte[] tmp_array = foo;
		// FLAW
		return tmp_array;
	}

}
