package ctci;

/**
 * Count the number of 2s between 0 and n.
 * @author Debosmit
 *
 */
public class Hard18_4 {

	private static int getNumDigits(int i) {
		int n = 1;
		if (i >= 100000000){i /= 100000000; n += 8;}
		if (i >= 10000){i /= 10000; n += 4;}
		if (i >= 100){i /= 100; n += 2;}
		if (i >= 10){i /= 10; n += 1;}
		
		return n;
	}
	
	public static void main(String[] args) {
		int n = Integer.MAX_VALUE;
		System.out.println(n);
		System.out.println(getNumDigits(n));
	}
}
