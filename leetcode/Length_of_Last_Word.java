package leetcode;

public class Length_of_Last_Word {
	public static int lengthOfLastWord(String s) {
		if(s.length() == 0 || s == null) 
			return 0;
		
		s = s.trim();
		
		int curLen = s.length() - 1;
		
		while(curLen >= 0) {
			if(s.charAt(curLen) == ' ') {
				break;
			}
			curLen--;
		}
		
		if(curLen > 0)
			return s.length() - 1 - curLen;
		
		return s.length();
    }
	
	public static void main(String[] args) {
		String s = "";
		System.out.println("Sentence: \"" + s + "\"");
		System.out.println("Length of last word: " + lengthOfLastWord(s));
		System.out.println();
		
		s = "a";
		System.out.println("Sentence: \"" + s + "\"");
		System.out.println("Length of last word: " + lengthOfLastWord(s));
		System.out.println();
		
		s = "a b";
		System.out.println("Sentence: \"" + s + "\"");
		System.out.println("Length of last word: " + lengthOfLastWord(s));
		System.out.println();

		s = "aaaa";
		System.out.println("Sentence: \"" + s + "\"");
		System.out.println("Length of last word: " + lengthOfLastWord(s));
		System.out.println();
		
		s = "a aaaa ";
		System.out.println("Sentence: \"" + s + "\"");
		System.out.println("Length of last word: " + lengthOfLastWord(s));
		System.out.println();

		s = "Hello World";
		System.out.println("Sentence: \"" + s + "\"");
		System.out.println("Length of last word: " + lengthOfLastWord(s));
	}
	
}
