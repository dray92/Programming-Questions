package ctci;

/**
 * Implement a method to perform basic string compression 
 * using the counts of repeated characters. If the 'compressed'
 * string would not become smaller than the original string, 
 * your method should return the original string. You can assume 
 * that the string only has upper and lower case letters.
 * @author Debosmit
 *
 */
public class ArrayString1_5 {
	public String getCompressedString(String st) {
		if(st == null || st.length() < 3)
			return st;
		int len = st.length();
		
		StringBuilder sb = new StringBuilder();
		int end;
		for(int index = 0 ; index < len ;) {
			end = index+1;
			char ch = st.charAt(index);
			while(end < len && st.charAt(end) == ch)
				end++;
			sb.append(ch);
			sb.append(end - index);
			index = end;
			if(sb.length() >= len)
				return st;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ArrayString1_5 compress = new ArrayString1_5();
		String st = "aabccccaaad";
		System.out.println("String: " + st);
		System.out.println("Compressed string: " + compress.getCompressedString(st));
	}
}
