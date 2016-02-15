package ctci;

/**
 * Get max of 2 numbers without using
 * if-else or any other comparison
 * @author Debosmit
 *
 */
public class Moderate17_4 {
	public int getMaxNoOF(int a, int b) {
		int s = sign(a-b);
		int sign = flip(s);
		return a*s + b*sign;
	}
	
	// flips bit
	public int flip(int bit) {
		return 1^bit;
	}
	
	// returns 1 if positive, 0 if negative
	public int sign(int n) {
		// MSB is 0 is positive, 1 if negative
		return flip((n>>31) & 0x1);
	}
	
	public int getMax(int a, int b) {
		int c = a - b;
		
		int sa = sign(a), sb = sign(b), sc = sign(c);
		
		// need k so that k = 1 if a>b
		//				  k = 0 if a<b
		
		// if a and b have different signs,
		// k = sign(a)		
		int signOfa = sa ^ sb;
		
		// if a and b have same sign,
		// k = sign(a-b)
		int signOfc = flip(signOfa);
		
		
		int k = signOfa*sa + signOfc*sc;
		
		int q = flip(k);
		
		return k*a + q*b;
	}
	
	public static void main(String[] args) {
		int a = 5, b = 3;
		Moderate17_4 Max = new Moderate17_4();
		System.out.println("Max: " + Max.getMaxNoOF(a,b));
		
		a = Integer.MAX_VALUE - 2;
		b = -15;
		System.out.println("Max: " + Max.getMax(a,b));
	}
	
}
