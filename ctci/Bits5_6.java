package ctci;

/**
 * Swap odd and even bits in the 
 * least possible number of instructions.
 * Eg. 1010 -> 0101
 * @author Debosmit
 *
 */
public class Bits5_6 {
	
	public int swapBits(int x) {
		int oddPlaces = x & 0xAAAAAAAA;
		int evenPlaces = x & 0x55555555;
		
		// moving odd places to the right by one place
		// moving even places to the left by one place
		return (oddPlaces >> 1) | (evenPlaces << 1);
	}
	
	public static void main(String[] args) {
		Bits5_6 SwapBits = new Bits5_6();
		int x = 13;
		System.out.println(x + ": " + Integer.toBinaryString(x));
		int y = SwapBits.swapBits(x);
		System.out.println(y + ": " + Integer.toBinaryString(y));
	}
}
