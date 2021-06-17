package testcases.CWE330_Use_of_Insufficiently_Random_Values;

import java.util.Random;

public class CWE330_Use_of_Insufficiently_Random_Values__Same_Seed_Random {
	
	public void bad01() {
		// FLAW
		Random random = new Random(123456);

		int value = random.nextInt();
	}
	
	public void bad01_1() {
		long seed = 123456;

		// FLAW
		Random random = new Random(seed);

		int value = random.nextInt();
	}
	
	public void bad02() {
		Random random = new Random();
		
		// FLAW
		random.setSeed(123456);
		
		int value = random.nextInt();
	}
	
	public void good() {
		Random random = new Random(System.currentTimeMillis());
		int value = random.nextInt();
	}

}
