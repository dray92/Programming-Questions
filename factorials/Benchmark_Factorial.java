package factorials;

public class Benchmark_Factorial {

	public static void main(String[] args) {
		int numIters = 1000000;
		
		// UUT = Hyper_Factorial
		Factorial_Abstract UUT = new Hyper_Factorial();
		long result = tester(UUT, numIters);
		System.out.println("Hyper_Factorial took             " + result + " msecs for " + numIters + " iterations");
		
		// UUT = Factorial_for_Simple_Minded
		UUT = new Factorial_for_Simple_Minded();
		result = tester(UUT, numIters);
		System.out.println("Factorial_for_Simple_Minded took " + result + " msecs for " + numIters + " iterations");
		
		// UUT = Additive_Moessner_Factorial
		UUT = new Additive_Moessner_Factorial();
		result = tester(UUT, numIters);
		System.out.println("Additive_Moessner_Factorial took " + result + " msecs for " + numIters + " iterations");
		
		// UUT = Split_Factorial
		UUT = new Split_Factorial();
		result = tester(UUT, numIters);
		System.out.println("Split_Factorial took             " + result + " msecs for " + numIters + " iterations");
		
		// UUT = Poor_Mans_Factorial
		UUT = new Poor_Mans_Factorial();
		result = tester(UUT, numIters);
		System.out.println("Poor_Mans_Factorial took         " + result + " msecs for " + numIters + " iterations");
	}
	
	
	private static long tester(Factorial_Abstract o, int numIters) {
		
		long start = System.currentTimeMillis();
		
		for(int iters = 0 ; iters < numIters ; iters++) 
			for(int i = 2 ; i <= 50 ; i++) 
				o.factorial(i);
			
		return (System.currentTimeMillis() - start);
	}
}
