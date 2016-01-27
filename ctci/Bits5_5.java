package ctci;

/** 
 * Number of bits to flip to 
 * convert integer A to B
 * @author Debosmit
 *
 */

public class Bits5_5 {

	public int numBitFlips(int a, int b) {
		if(a == b)
			return 0;
		
		// xor gives the bits that are different
		// counting these will give the number of bits to
		// be flipped
		
		int count = 0;
		for (int c = a ^ b; c != 0; c = c >> 1) 
			count += c & 1;
		
		return count;
	}
	
	public static void main(String[] args) {
		Bits5_5 flip = new Bits5_5();
		
		int a = 5;
		int b = 4;
		System.out.println("Num bit flips to change " + a +
				" to " + b + ": " + flip.numBitFlips(a,b));
	}
	
}
