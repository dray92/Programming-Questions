package factorials;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Additive_Moessner_Factorial extends Factorial_Abstract {

	private Map<Integer, BigInteger> factorialMap = new HashMap<Integer, BigInteger>();
	
	@Override
	public BigInteger factorial(int n) {
        if (n < 0) 
            throw new ArithmeticException("Factorial: n has to be >= 0, but was " + n);
        
        // if factorial was calculated before
	    if(factorialMap.containsKey(n))
	    	return factorialMap.get(n);

        BigInteger[] s = new BigInteger[n + 1];
        s[0] = BigInteger.ONE;

        for (int m = 1; m <= n; m++) {
            s[m] = BigInteger.ZERO;
            for (int k = m; k >= 1; k--) {
                for (int i = 1; i <= k; i++) {
                    s[i] = s[i].add(s[i - 1]);
                }
            }
        }
        
        factorialMap.put(n, s[n]);
        
        return s[n];
    }
	
	public static void main(String[] args) {
		Split_Factorial SF = new Split_Factorial();
		for(int i = 2 ; i <= 50 ; i++) {
			System.out.println(i + "! = " + SF.factorial(i).toString());
		}
	}

	
}
