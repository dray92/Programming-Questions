package randomCode;

import java.math.BigInteger;
import java.util.Random;

public class Benchmark {

	public static void main(String[] args) {
		Random r = new Random();
	    int[] ints = new int[5000000];
	    for (int i = 0 ; i < ints.length ; i++)
	        ints[i] = r.nextInt();

	    for (int i = 0 ; i < ints.length-1; i++)
	        GCD(i,i+1);
	    for (int i = 0 ; i < ints.length-1; i++)
	        gcdThing(i, i + 1);

	    long start = System.currentTimeMillis();
	    for (int i = 0 ; i < ints.length-1; i++)
	        GCD(i,i+1);
	    System.out.println("GCD: " + (System.currentTimeMillis() - start));

	    start = System.currentTimeMillis();
	    for (int i = 0 ; i < ints.length-1; i++)
	        gcdThing(i, i + 1);
	    System.out.println("gcdThing: " + (System.currentTimeMillis() - start));
	}
	
	private static int gcdThing(int a, int b) {
	    BigInteger gcd = BigInteger.valueOf(a).gcd(BigInteger.valueOf((b)));
	    return gcd.intValue();
	}
	
	private static int GCD(int a, int b) { 
		return b==0 ? a : GCD(b, a%b); 
	}
}
