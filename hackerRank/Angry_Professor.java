package hackerRank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/angry-professor
 * 
 * A Discrete Mathematics professor has a class of NN students. Frustrated with their lack of 
 * discipline, he decides to cancel class if fewer than KK students are present when class starts.
 * 
 * Given the arrival time of each student, determine if the class is canceled.
 * 
 * Input Format
 * 
 * The first line of input contains TT, the number of test cases.
 * 
 * Each test case consists of two lines. The first line has two space-separated integers, 
 * NN (students in the class) and KK (the cancellation threshold).
 * The second line contains NN space-separated integers (a1,a2,…,aNa1,a2,…,aN) describing the 
 * arrival times for each student.
 * 
 * Note: Non-positive arrival times (a_i≤0) indicate the student arrived early or on time; positive 
 * arrival times (a_i>0) indicate the student arrived a_i minutes late.
 * 
 * Output Format
 * 
 * For each test case, print the word YES if the class is canceled or NO if it is not.
 * 
 * Constraints
 * 
 *     1 ≤ T ≤ 100
 *     1 ≤ N ≤ 1000
 *     1 ≤ K ≤ N
 *    −100 ≤ a_i ≤ 100, where i∈[1,N]
 * 
 * Note
 * If a student arrives exactly on time (a_i=0), the student is considered to have entered before the class started.
 * @author Debosmit
 *
 */
public class Angry_Professor {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testcase = in.nextInt();

		for(int i = 0; i < testcase; i++) {

			int N = in.nextInt();
			int K = in.nextInt();
	
			int count = 0;

			while(N > 0) {
				int s = in.nextInt();
				
				if(s <= 0)
					count++;
				
				N--;
	
			}
	
			if(count >= K)
				System.out.println("NO");
			else
				System.out.println("YES");

		}
	}
}
