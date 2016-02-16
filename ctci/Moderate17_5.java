package ctci;

/**
 * Game of master mind. There are 4 slots. 
 * Each will contain a ball that is either
 * red, yellow, green or blue. The computer
 * chooses this combination and the user
 * needs to guess. 
 * Correct color, correct slot -> hit
 * correct color, incorrect slot -> pseduo-hit
 * A hit doesn't count as a pseudo-hit
 * @author Debosmit
 *
 */
public class Moderate17_5 {
	
	final int NUM_COLORS = 4;
	
	public Result getResult(String actual, String guess) {
		int[] freq = new int[NUM_COLORS];
		int hits = 0, pseudohits = 0;
		
		// hits
		for(int i = 0 ; i < guess.length() ; i++)
			if(actual.charAt(i) == guess.charAt(i))
				hits++;
			else 
				freq[getCode(guess.charAt(i))]++;
			
		// pseudohits
		for(int i = 0 ; i < guess.length() ; i++) {
			int code = getCode(guess.charAt(i));
			if(code >= 0 && freq[code] > 0 && guess.charAt(i) != actual.charAt(i)) {
				pseudohits++;
				freq[code]--;
			}
		}
		
		return new Result(hits, pseudohits);
		
	}
	
	private int getCode(char c) {
		switch(c) {
			case 'B':
				return 0;
			
			case 'G':
				return 1;
				
			case 'R':
				return 2;
			
			case 'Y':
				return 3;
				
			default:
				return -1;
		}
	}
	
	public class Result {
		int hit, pseudohit;
		
		public Result(int hit, int pseudohit) {
			this.hit = hit;
			this.pseudohit = pseudohit;
		}
	}
}
