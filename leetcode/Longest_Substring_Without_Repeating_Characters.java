package leetcode;

public class Longest_Substring_Without_Repeating_Characters {
	
	public static int lengthOfLongestSubstring(String s) {
		int start = 0, end = 0, maxLen = 0;
		int[] index = new int[256];
		int[] exists = new int[256];
		while(end < s.length()){
			if(exists[(int) s.charAt(end)] == 0){
				exists[(int) s.charAt(end)]++;
				index[(int) s.charAt(end)] = end;
				maxLen = Math.max(maxLen, end - start + 1);
				end++;}
			else{
				while(end > start){
					exists[(int) s.charAt(start)] = 0;
					start++;
				}
				start = index[(int) s.charAt(end)] + 1;
				index[(int) s.charAt(end)] = end;
				end = start;
			}
		}
     
        return maxLen;
    }
	
	public static void main(String[] args) {
		String string = "au";
		System.out.println("String: " + string);
		int length = lengthOfLongestSubstring(string);
		System.out.println("The length of the longest non-repeating character" +
			       " substring is " + length);
		
	}
}
