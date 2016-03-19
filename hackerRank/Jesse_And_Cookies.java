package hackerRank;

import java.util.PriorityQueue;
import java.util.Scanner;


/** 
 * https://www.hackerrank.com/challenges/jesse-and-cookies
 * @author Debosmit
 *
 */
public class Jesse_And_Cookies {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = sc.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		while(n > 0) {
			pq.add(sc.nextInt());
			n--;	
		}
		int ops = 0;
		while( pq.peek() < min) {
			ops++;
			int least = pq.poll();
			int secondLeast = pq.poll();
			pq.add(least + 2*secondLeast);
            
            // one element left and it is smaller than min
            if(pq.size() == 1 && pq.peek() < min) {
                System.out.println(-1);
                sc.close();
                return;
            }
		}
		System.out.println(ops);
		sc.close();
	}
}
