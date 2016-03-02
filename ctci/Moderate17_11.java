package ctci;

import java.util.Random;

/**
 * Given rand5() (random numbers in [0,4]]),
 * write a function rand7 (random numbers in [0,6]])
 * @author Debosmit
 *
 */
public class Moderate17_11 {

	public int rand5() {
		Random rand = new Random();
		return Math.abs(rand.nextInt())%5;
	}
	
	// key is to ensure that all numbers
	// in the range are equally probable
	// one way is to increase the range so
	// much, that all numbers have close
	// to, or in the best case, equal 
	// probabilities
	public int rand7() {
		int num = Integer.MAX_VALUE;
		while(num >= 21) {
			num = 5*rand5() + rand5();
		}
		return num%7;
	}
	
	public static void main(String[] args) {
		int[] counts = new int[7];
		Moderate17_11 Randoms = new Moderate17_11();
		for(int i = 0 ; i < 100000 ; i++) {
			int num = Randoms.rand7();
			counts[num]++;
		}
		for(int i = 0 ; i < 7 ; i++)
			System.out.println("Freq of " + i + " : " + counts[i]);
	}
		
}
