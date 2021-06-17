package testcases.CWE495_Private_Data_Structure_Returned_From_A_Public_Method;

import java.util.Arrays;

public class CWE495_Private_Data_Structure_Returned_From_A_Public_Method__good {
	
	private byte[] foo = null;
	
	public byte[] getFoo_good1() {
		byte[] tmp_array = null;
			
		if (foo != null) {
			tmp_array = new byte[foo.length];
			
			for(int i=0; i<foo.length; i++) {
				tmp_array[i] = foo[i];
			}
		}
		return tmp_array;
	}
	
	public byte[] getFoo_good2() {
		byte[] tmp_array = new byte[foo.length];
		System.arraycopy(foo, 0, tmp_array, 0, tmp_array.length);
		return tmp_array;
	}
	
	public byte[] getFoo_good3() {
		byte[] tmp_array = Arrays.copyOf(foo, foo.length);
		return tmp_array;
	}
	
	public byte[] getFoo_good4() {
		byte[] tmp_array = Arrays.copyOfRange(foo, 0, foo.length);
		return tmp_array;
	}
}