package factorials;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Poor_Mans_Factorial extends Factorial_Abstract {

	private long N;
	
	@Override
	public BigInteger factorial(int n) {
		
		return new BigInteger(getFactorial(n));
	}
	
	private Map<Integer, String> factorialMap = new HashMap<Integer, String>();
	
	public String getFactorial(int n) {
        if (n < 0) 
            throw new ArithmeticException("Factorial: n has to be >= 0, but was " + n);

        if (n < 2) 
            return "1";
        
        // if factorial was calculated before
	    if(factorialMap.containsKey(n))
	    	return factorialMap.get(n);

        DecInteger p = new DecInteger(1);
        DecInteger r = new DecInteger(1);

        N = 1;
        int h = 0, shift = 0, high = 1;
        int log2n = (int) Math.floor(Math.log(n) / Math.log(2));

        while (h != n) {
            shift += h;
            h = n >> log2n--;
            int len = high;
            high = (h & 1) == 1 ? h : h - 1;
            len = (high - len) / 2;

            if (len > 0) {
                p = p.multiply(product(len));
                r = r.multiply(p);
            }
        }

        r = r.multiply(DecInteger.pow2(shift));
        
        factorialMap.put(n, r.toString());
        return factorialMap.get(n);
    }

	private Map<Integer, DecInteger> productMap = new HashMap<Integer, DecInteger>();
    private DecInteger product(int n) {
    	
    	if(productMap.containsKey(n))
			return productMap.get(n);
    	
        int m = n / 2;
        if (m == 0) {
            return new DecInteger(N += 2);
        }
        if (n == 2) {
            return new DecInteger((N += 2) * (N += 2));
        }
        
        DecInteger result = product(n - m).multiply(product(m));
	    
	    productMap.put(n, result);
	    return result;
    }
    
    public static void main(String[] args) {
		Split_Factorial SF = new Split_Factorial();
		for(int i = 2 ; i <= 50 ; i++) {
			System.out.println(i + "! = " + SF.factorial(i).toString());
		}
	}

	static class DecInteger {

	    private static final long mod = 100000000L;
	    private final int[] digits;
	    private final int digitsLength;

	    public DecInteger(long value) {
	        digits = new int[]{(int) value, (int) (value >>> 32)};
	        digitsLength = 2;
	    }

	    private DecInteger(int[] digits, int length) {
	        this.digits = digits;
	        digitsLength = length;
	    }

	    public static DecInteger pow2(int e) {
	        if (e < 31) {
	            return new DecInteger((int) Math.pow(2, e));
	        }
	        return pow2(e / 2).multiply(pow2(e - e / 2));
	    }

	    public DecInteger multiply(DecInteger b) {
	        int alen = this.digitsLength, blen = b.digitsLength;
	        int clen = alen + blen;
	        int[] digit = new int[clen];

	        for (int i = 0; i < alen; i++) {
	            long temp = 0;
	            for (int j = 0; j < blen; j++) {
	                temp = temp + ((long) this.digits[i]) * ((long) b.digits[j]) + digit[i + j];
	                digit[i + j] = (int) (temp % mod);
	                temp = temp / mod;
	            }
	            digit[i + blen] = (int) temp;
	        }

	        int k = clen - 1;
	        while (digit[k] == 0) {
	            k--;
	        }

	        return new DecInteger(digit, k + 1);
	    }

	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder(digitsLength * 10);
	        sb = sb.append(digits[digitsLength - 1]);
	        for (int j = digitsLength - 2; j >= 0; j--) {
	            sb = sb.append(Integer.toString(digits[j] + (int) mod).substring(1));
	        }
	        return sb.toString();
	    }
	}
}
