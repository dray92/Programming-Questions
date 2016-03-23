package projectEuler;

import java.math.BigInteger;

public class Problem3 {

	private static final int certainty = 10000;
	
	public static void main(String[] args) {
		BigInteger val = new BigInteger("600851475143");
		BigInteger sqrt = sqrt(val);
		
		System.out.println("Is number probably prime? " + val.isProbablePrime(certainty));
		
//		// Timing 
//		long total1 = 0, total2 = 0, start = 0, end = 0;
//		for(int i = 0 ; i < 1000000 ; i++) {
//			start = System.nanoTime();
//			sqrt = sqrt(val);
//			end = System.nanoTime();
//			total1 = (end-start);
//			
//			start = System.nanoTime();
//			sqrt = sqrt2(val);
//			end = System.nanoTime();
//			total2 = (end-start);
//		}
//		
//		System.out.println(total1);
//		System.out.println(total2);
		
		for(BigInteger i = BigInteger.valueOf(2); i.compareTo(sqrt) < 0 ; i = i.add(BigInteger.ONE)) {
			// check if i is a factor
			BigInteger[] divAndRem = val.divideAndRemainder(i);
//			System.out.println("Rem for i = " + i + " : " + divAndRem[1]);
			if(divAndRem[1].equals(BigInteger.ZERO)) {
				// check if `i` or `val/i` is a prime factor
				if(i.isProbablePrime(certainty)) {
					System.out.println(i);
				}
				
				if(divAndRem[0].isProbablePrime(certainty)) {
					System.out.println(divAndRem[0]);
				}
			}
		}
	}
	
	private static BigInteger newtonIteration(BigInteger n, BigInteger x0) {
	    final BigInteger x1 = n.divide(x0).add(x0).shiftRight(1);
	    return x0.equals(x1)||x0.equals(x1.subtract(BigInteger.ONE)) ? x0 : newtonIteration(n, x1);
	}
	
	public static BigInteger sqrt(final BigInteger number) {
	    if(number.signum() == -1)
	        throw new ArithmeticException("We can only calculate the square root of positive numbers.");
	    return newtonIteration(number, BigInteger.ONE);
	}
	
	public static BigInteger sqrt2(BigInteger n) {
		  BigInteger a = BigInteger.ONE;
		  BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
		  while(b.compareTo(a) >= 0) {
		    BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
		    if(mid.multiply(mid).compareTo(n) > 0) b = mid.subtract(BigInteger.ONE);
		    else a = mid.add(BigInteger.ONE);
		  }
		  return a.subtract(BigInteger.ONE);
		}
}
