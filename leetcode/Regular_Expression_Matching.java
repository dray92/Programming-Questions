package leetcode;

public class Regular_Expression_Matching {
	
	public static boolean isMatch2(String s, String p) {
		
		if(p.length() == 0)
			return s.length() == 0;
		
//		case 1: length of pattern is 1
//		case 2: the second char of pattern is not "*"
//		case 3: the second char of pattern is "*"; complex

		// case 1
		if(p.length() == 1) {
			// if the length of s is 0, return false
			if (s.length() < 1) 
				return false;
			
			// if the first char does not match, return false
			else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) 
				return false;
			
			// otherwise, compare the rest of the string of s and p.
			else 
				return isMatch(s.substring(1), p.substring(1));
		}
		
		// case 2
		if (p.charAt(1) != '*') {
			// if the length of s is 0, return false
			if (s.length() < 1)
				return false;
			
			// first character matching test
			if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.'))
				return false;
			
			// first character matched; continue recursively with rest of strings
			else 
				return isMatch(s.substring(1), p.substring(1));
		
		}
		
		// case 3
		else {
			// two cases:
			//	-- char and * can account for 0 elements
			//	-- char and * accounts for > 0 elements
			
			// first case
			if(isMatch(s, p.substring(2)))
				return true;
			
			// second case
			int i = 0;
			while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')){
				if (isMatch(s.substring(i+1), p.substring(2)))
					return true;
				i++;
			}
			return false;
			
		}
	}
	
public static boolean isMatch(String s, String p) {
		
		if(p.length() == 0)
			return s.length() == 0;
		
//		case 1: length of pattern is 1
//		case 2: the second char of pattern is not "*"
//		case 3: the second char of pattern is "*"; complex

		// case 1 & case 2
		if(p.length() == 1 || p.charAt(1) != '*') {
			// if the length of s is 0, return false
			if (s.length() < 1) 
				return false;
			
			// if the first char does not match, return false
			else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) 
				return false;
			
			// otherwise, compare the rest of the string of s and p.
			else
				return isMatch(s.substring(1), p.substring(1));
		}
		
		// case 3
		else {
			// two cases:
			//	-- char and * can account for 0 elements
			//	-- char and * accounts for > 0 elements
			
			// first case
			if(isMatch(s, p.substring(2)))
				return true;
			
			// second case
			int i = 0;
			while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')){
				if (isMatch(s.substring(i + 1), p.substring(2)))
					return true;
				i++;
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("isMatch(\"aa\", \"a\") : " + isMatch("aa","a"));
		System.out.println("isMatch(\"aa\", \"aa\") : " + isMatch("aa","aa")); 
		System.out.println("isMatch(\"aaa\", \"aa\") : " + isMatch("aaa","aa")); 
		System.out.println("isMatch(\"aa\", \"a*\") : " + isMatch("aa", "a*"));
		System.out.println("isMatch(\"aa\", \".*\") : " + isMatch("aa", ".*"));
		System.out.println("isMatch(\"ab\", \".*\") : " + isMatch("ab", ".*"));
		System.out.println("isMatch(\"aab\", \"c*a*b\") : " + isMatch("aab", "c*a*b"));
	}
}
