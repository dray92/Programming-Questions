package leetcode;

public class Implement_strStr {

	public static int strStr(String haystack, String needle) {
		
		if(haystack==null || needle==null)    
            return 0;
		
		int h = haystack.length();
		int n = needle.length();
	 
		if (n > h)
			return -1;
		if (n == 0 || h == 0)
			return 0;
		
		int[] table = getFailureFunction(needle);
		
        int i = 0;	// position of current index in needle
        
        while(i <= h - n) {
        	int success = 1;
    		for (int j = 0; j < n; j++) {
    			if (needle.charAt(0) != haystack.charAt(i)) {
    				success = 0;
    				i++;
    				break;
    			} else if (needle.charAt(j) != haystack.charAt(i + j)) {
    				success = 0;
    				i = i + j - table[j - 1];
    				break;
    			}
    		}
    		if (success == 1)
    			return i;
    	}
		
		return -1;
    }
	
	public static void main(String[] args) {
		String needle = "abc";
		String haystack = "ababc";
		System.out.println("Needle: " + needle + " || Haystack: " + haystack);
		System.out.println("Location: " + strStr(haystack, needle) + "\n\n");
		
		needle = "abcdabd";
		haystack = "abcababcadb";
		System.out.println("Needle: " + needle + " || Haystack: " + haystack);
		System.out.println("Location: " + strStr(haystack, needle) + "\n\n");
		
		needle = "aa";
		haystack = "ababaabaaa";
		System.out.println("Needle: " + needle + " || Haystack: " + haystack);
		System.out.println("Location: " + strStr(haystack, needle) + "\n\n");
	}

	private static int[] getFailureFunction(String needle) {
		int[] next = new int[needle.length()];
		next[0] = 0;
	 
		for (int i = 1; i < needle.length(); i++) {
			int index = next[i - 1];
			while (index > 0 && needle.charAt(index) != needle.charAt(i)) {
				index = next[index - 1];
			}
	 
			if (needle.charAt(index) == needle.charAt(i)) {
				next[i] = next[i - 1] + 1;
			} else {
				next[i] = 0;
			}
		}
	 
		return next;
	}
}
