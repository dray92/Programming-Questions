package leetcode;

/**
 * Source: http://courses.csail.mit.edu/iap/interview/Hacking_a_Google_Interview_Practice_Questions_Person_A.pdf
 * Check if input string is the substring of
 * another string.
 * @author Debosmit
 *
 */
public class Substring {

	public int isSubstring(String needle, String haystack) {
		if(needle == null || haystack == null || (needle.length() > haystack.length()))
			throw new IllegalArgumentException();
		
		if(needle.length() == 0)
			return 0;
		
		for(int i = 0 ; i < haystack.length() ; i++) {
			if(i + needle.length() > haystack.length())
				return -1;
			
			int m = i;
			for(int j = 0 ; j < needle.length() ; j++) {
				if(needle.charAt(j) == haystack.charAt(m)) {
					if(j == needle.length() - 1)
						return i;
					m++;
				} else 
					break;
				
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Substring Sub = new Substring();
		String s1 = "abate", s2 = "bat";
		int indx = Sub.isSubstring(s2, s1);
		System.out.println("First occurence of \'" + s2 + "\' in \'" + s1 + "\' is at: " + indx);
	}
}
