package factorials;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Split_Factorial extends Factorial_Abstract {

	private long N;
	private Map<Integer, BigInteger> factorialMap = new HashMap<Integer, BigInteger>();
	
	@Override
	public BigInteger factorial(int n) {
	    if (n < 0) 
	        throw new ArithmeticException("Factori n has to be >= 0, but was " + n);

	    if (n < 2)
	        return BigInteger.ONE;

	    // if factorial was calculated before
	    if(factorialMap.containsKey(n))
	    	return factorialMap.get(n);

	    BigInteger p = BigInteger.ONE;
	    BigInteger r = BigInteger.ONE;

	    N = 1;

	    int log2n = 31 - Integer.numberOfLeadingZeros(n);

	    int h = 0, shift = 0, high = 1;

	    while (h != n) {

	        shift += h;
	        h = n >>> log2n--;

	        int len = high;
	        high = (h & 1) == 1 ? h : h - 1;

	        len = (high - len) / 2;
	       
	        if (len > 0) {
	            p = p.multiply(product(len));
	            r = r.multiply(p);
	        }
	    }
	    BigInteger result = r.shiftLeft(shift);
	    factorialMap.put(n, result);
	    return result;
	}

	private Map<Integer, BigInteger> productMap = new HashMap<Integer, BigInteger>();
	private BigInteger product(int n) {
		
		if(productMap.containsKey(n))
			return productMap.get(n);
		
	    int m = n / 2;

	    if (m == 0)
	        return BigInteger.valueOf(N += 2);

	    if (n == 2)
	        return BigInteger.valueOf((N += 2) * (N += 2));

	    BigInteger result = product(n - m).multiply(product(m));
	    
	    productMap.put(n, result);
	    return result;
	}
	
	public static void main(String[] args) {
		Split_Factorial SF = new Split_Factorial();
		for(int i = 2 ; i <= 50 ; i++) {
			System.out.println(i + "! = " + SF.factorial(i).toString());
		}
	}
}
