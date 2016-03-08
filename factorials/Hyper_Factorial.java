package factorials;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Hyper_Factorial extends Factorial_Abstract {

	private Map<Integer, BigInteger> factorialMap = new HashMap<Integer, BigInteger>();
	private boolean nostart;
    private long S, K, A;
    
	@Override
	public BigInteger factorial(int n) {
		if (n < 0) 
	        throw new ArithmeticException("Factori n has to be >= 0, but was " + n);

	    if (n < 2)
	        return BigInteger.ONE;

	    // if factorial was calculated before
	    if(factorialMap.containsKey(n))
	    	return factorialMap.get(n);

        nostart = false;
        int h = n / 2;
        S = h + 1;
        K = S + h;
        A = (n & 1) == 1 ? K : 1;
        if ((h & 1) == 1) {
            A = -A;
        }
        K += 4;

        BigInteger result = hyperFact(h + 1).shiftLeft(h);
        factorialMap.put(n, result);
        return result;
    }

    private BigInteger hyperFact(int l) {
        if (l > 1) {
            int m = l / 2;
            return hyperFact(m).multiply(hyperFact(l - m));
        }

        if (nostart) {
            S -= K -= 4;
            return BigInteger.valueOf(S);
        }

        nostart = true;
        return BigInteger.valueOf(A);
    }
    
    public static void main(String[] args) {
		Split_Factorial SF = new Split_Factorial();
		for(int i = 2 ; i <= 50 ; i++) {
			System.out.println(i + "! = " + SF.factorial(i).toString());
		}
	}

}
