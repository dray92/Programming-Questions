package ctci;

import java.util.Arrays;

/**
 * Write a method to shuffle a deck
 * of cards. It must be a perfect
 * shuffle - in other words, each
 * of the 52! permutations of the
 * deck has to be equally likely.
 * @author Debosmit
 *
 */
public class Hard18_2 {

	private int getRandomRange(int min, int max) {
		return min + (int)( Math.random() * (max - min + 1) );
	}
	
	public void shuffle(int[] cards) {
		for(int i = 1 ; i < cards.length ; i++) {
			// for every index, get a random index
			// in the range [0,i]. Swap current 
			// index with that. Obviously, including 
			// 0 in the loop didn't make sense.
			int randomIndx = getRandomRange(0, i);
			
			if(randomIndx == i)
				continue;
			
			cards[randomIndx] ^= cards[i];
			cards[i] ^= cards[randomIndx];
			cards[randomIndx] ^= cards[i];
		}
	}
	
	public static void main(String[] args) {
		Hard18_2 Shuffle = new Hard18_2();
		int[] cards = new int[]{1,2,3,4,5,6,7,8,9};
		System.out.println("Before: " + Arrays.toString(cards));
		Shuffle.shuffle(cards);
		System.out.println("After : " + Arrays.toString(cards));
	}
}
