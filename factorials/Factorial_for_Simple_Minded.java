package factorials;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * NEVER USE THIS!!!!
 * @author Debosmit
 *
 */
public class Factorial_for_Simple_Minded extends Factorial_Abstract {

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
	    
	    BigInteger res = BigInteger.valueOf((long)n).multiply(factorial(n-1));
	    factorialMap.put(n, res);
		return res;
	}

	public static void main(String[] args) {
		Split_Factorial SF = new Split_Factorial();
		for(int i = 2 ; i <= 50 ; i++) {
			System.out.println(i + "! = " + SF.factorial(i).toString());
		}
	}
}
