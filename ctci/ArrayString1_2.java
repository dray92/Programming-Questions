package ctci;

/**
 * Implement a function void reverse(char* str) in C or C++
 * which reverses a null-terminated string
 * @author Debosmit
 *
 */
public class ArrayString1_2 {
	
	// create StringBuilder so that new string 
	// isn't created every time
	// go from i ∈ [0, length/2]
	// and keep replacing chars from (length/2, length-1]
	public String reverse(String st) {
		StringBuilder sb = new StringBuilder(st);
		int len = st.length();
		for(int i = 0 ; i < len/2 ; i++) {
			char lastChar = sb.charAt(len-i-1);
			sb.replace(len-i-1, len-i, "" + sb.charAt(i));
			sb.replace(i, i+1, "" + lastChar);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String st = "abcdef";
		ArrayString1_2 rev = new ArrayString1_2();
		System.out.println("String: " + st);
		System.out.println("Reversed: " + rev.reverse(st));
	}
}
