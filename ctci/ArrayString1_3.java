package ctci;

/**
 * Given 2 strings, write a methid to decide if one is a 
 * permutation of the other. 
 * @author Debosmit
 *
 */
public class ArrayString1_3 {

	public boolean isPermutation(String s, String t) {
		if(s.length() != t.length())
			return false;
		
		int xor = 0;
		
		for(int i = 0 ; i < s.length() ; i++)
			xor ^= s.charAt(i);
		
		for(int i = 0 ; i < t.length() ; i++)
			xor ^= t.charAt(i);
		
		return xor == 0;
	}
	
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] letters = new int[128];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			if (letters[c] == 0)
				++num_unique_chars;
			++letters[c];
		}
		for (int i = 0; i < t.length(); ++i) {
			int c = (int) t.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// itÕs a match if t has been processed completely
					return true;
					//return i == t.length() - 1;
				}
			}
		}
		return false;
	}	
	
	public static void main(String[] args) {
		String s = "abcabc";
		String t = "bcaabc";
		System.out.println("String 1: " + s);
		System.out.println("String 2: " + t);
		
		ArrayString1_3 permute = new ArrayString1_3();
		System.out.println("Are they permutations? " + permute.isPermutation(s,t));
		System.out.println("Are they permutations? " + permute.isAnagram(s,t));
	}
}
