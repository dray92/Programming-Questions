package leetcode;

public class Divide_Two_Integers {
	public static int divide(int dividend, int divisor) {
        
		// dividing by 0
		if(divisor == 0) 
			return Integer.MAX_VALUE;
		
		// smallest number divided by -1 yields max number
		// normal division would cause an overflow by 1
		if(divisor == -1 && dividend == Integer.MIN_VALUE) 
			return Integer.MAX_VALUE;
		
		//get positive values
	    long pDividend = Math.abs((long)dividend);
	    long pDivisor = Math.abs((long)divisor);
		
	    // going the bit-shift route, since multiplication isn't allowed
	    // number = a_0*2^0 + a_1*2^1 + a_2*2^2 + ... + a_n*2^n
	    
	    int quotient = 0;
	    
	    while(pDividend >= pDivisor) {
	    	
	    	// calculating number of left shifts
	    	int numShift = 0;    
	        while(pDividend >= (pDivisor << numShift))
	            numShift++;
	        
	        // dividend minus the largest shifted divisor
	        quotient = quotient + (1 << (numShift - 1));
	        pDividend = pDividend - (pDivisor << (numShift - 1));
	    }
	    
	    if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
	        return quotient;
	    return -quotient;
    }
	
	public static void main(String[] args) {
		int divisor = 5;
		int dividend = 15;
		System.out.println("Dividend: " + dividend);
		System.out.println("Divisor: " + divisor);
		System.out.println("Quotient: " + divide(dividend, divisor) + "\n\n");
		
		divisor = 10;
		dividend = 15;
		System.out.println("Dividend: " + dividend);
		System.out.println("Divisor: " + divisor);
		System.out.println("Quotient: " + divide(dividend, divisor) + "\n\n");
		
		divisor = 20;
		dividend = 15;
		System.out.println("Dividend: " + dividend);
		System.out.println("Divisor: " + divisor);
		System.out.println("Quotient: " + divide(dividend, divisor) + "\n\n");
		
	}
}
