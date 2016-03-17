package hackerRank;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/counter-game
 * @author Debosmit
 *
 */
public class Counter_Game {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int runs = sc.nextInt();
        
        while(runs-- > 0) {
            BigInteger n = sc.nextBigInteger();
            playGame(n);
        }
    }
    
    private static void playGame(BigInteger n) {
        
        long count = 0;
        
        // while n is not 0
        while(n.compareTo(BigInteger.ZERO) != 0) {
        	// if n & n-1 == 0 ==>> power of 2
            if (n.and(n.subtract(BigInteger.ONE)).compareTo(BigInteger.ZERO) == 0) 
                n = n.shiftRight(1);		// n = n/2
            else
                n = n.subtract(largestPow2(n));	// n -= lower power
            count++;
        }
        if( (count & 0x1) == 1)
            System.out.println("Louise");
        else
            System.out.println("Richard");
    }
    
    private static BigInteger largestPow2(BigInteger n) {
    	while(n.and(n.subtract(BigInteger.ONE)).compareTo(BigInteger.ZERO) != 0)
    		n = n.and(n.subtract(BigInteger.ONE));
        
    	return n;
    }
    
}
