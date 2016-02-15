package ctci;

/**
 * Calculate the number of trailing zeros in n!
 * @author Debosmit
 *
 */
public class Moderate17_3 {

	public int getNumZerosFactorial(int n) {
		if(n <= 1)
			return 0;
		
		int num5 = 0;
		/*
		 *  0's will show up from multiplication
		 *  by 10. 10 can come from multiplication by 2*5.
		 *  There are usually more 2's than 5's. Calculating number 
		 *  of 5's would work.
		 */
		while(n > 0) {
			num5 += getNum5s(n);
			n--;
		}
		
		
		return num5;
	}

	private int getNum5s(int n) {
		int num = 0;
		while(n > 0) {
			int q = n/5;
			// check if 5 is a factor
			if(q*5 == n) {
				num += 1;
				n = n/5;
			} else 
				break;
			
		}
		return num;
	}
	
	public static void main(String[] args) {
		Moderate17_3 Factorial = new Moderate17_3();
		int n = 100;
		System.out.println("Number of 0s in " + n + "! = " + 
						Factorial.getNumZerosFactorial(n));
	}
}
