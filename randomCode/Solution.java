package randomCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
       
        // getting N
        int N = scan.nextInt();
        if(N<3 || N>10000000)
        	throw new IllegalArgumentException("N must lie in [3, 10000000]");
        
        // getting M
        int M = scan.nextInt();
        if(M<1 || M>200000)
        	throw new IllegalArgumentException("M must lie in [1, 200000]");
        
        // create arrayList and fill with 0
        List<Long> list = new ArrayList<Long>(N);
        for(int i = 0 ; i<N ; i++)
        	list.add((long)0);
        
        
        // pass Scanner, list and M to helper function
        process(scan, list, M, N);
        
    }

    // helper function that accepts scanner, list and M(number of lines to read
    // from the scanner)
	private static void process(Scanner scan, List<Long> list, int M, int N) {
		while(M != 0) {
			// value a
        	int a = scan.nextInt();
        	
        	// value b
        	int b = scan.nextInt();
        	
        	if(a < 1 || a > b || b > N)
        		throw new IllegalArgumentException("1 < a <= b <= N");
        	
        	// value k
        	int k = scan.nextInt();
        	if(k<0 || k>1000000000)
        		throw new IllegalArgumentException("1<=k<=1000000000");
        	
        	// add k to all indices
        	for(int i = a ; i <= b ; i++)
        		list.set(i-1,list.get(i-1)+k);
        	
        	M--;
        }
		// close scanner
		scan.close();
		
		// get max
		Collections.sort(list);
		
		// print max
		System.out.println(list.get(list.size()-1));
		
	}
}