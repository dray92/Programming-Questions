package hackerRank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Roy wanted to increase his typing speed for programming contests. So, his friend advised him to type the sentence "The quick brown fox jumps over the lazy dog" repeatedly, because it is a pangram. (Pangrams are sentences constructed by using every letter of the alphabet at least once.)

After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.

Given a sentence ss, tell Roy if it is a pangram or not.
 * @author Debosmit
 *
 */
public class Pangrams {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String st = sc.nextLine();
//        if(sc.hasNext())
//        	st += sc.nextLine();
        
        if(!valid(st))
        	System.out.print("not ");
        System.out.println("pangram");
    }

	private static boolean valid(String st) {
		if(st.length() < 26)
			return false;
		st = st.toLowerCase();
		Set<Character> set = new HashSet<Character>();
		for(int i = 0 ; i < st.length() ; i++) {
			char c = st.charAt(i);
			if(c >= 97 && c <= 122)
				set.add(c);
		}
		return set.size() == 26;
	}
}
