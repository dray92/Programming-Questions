package projectEuler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem12 {
	
	public static void main(String[] args) {
		long start = 0;
		
		for(long i = 1 ; i > 0 ; i++) {
			start += i;
			long nod = numberOfDivisors(start);
			start++;
			if(nod >= 500) {
				System.out.println(start);
				break;
			}
			if(i % 1000 == 0)
				System.out.println(i);
		}
	}

	private static long numberOfDivisors(long number) {
	    long nod = 0;
	    long sqrt = (long) Math.sqrt(number);
	 
	    for(long i = 1; i<= sqrt; i++){
	        if(number % i == 0){
	            nod += 2;
	        }
	    }
	    // correction if the number is a perfect square
	    if (sqrt * sqrt == number) {
	        nod--;
	    }
	 
	    return nod;
	}
}
