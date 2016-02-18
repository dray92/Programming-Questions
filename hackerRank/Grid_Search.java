package hackerRank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-grid-search
 * @author Debosmit
 *
 */
public class Grid_Search {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int R = in.nextInt();
            int C = in.nextInt();
            String G[] = new String[R];
            for(int G_i=0; G_i < R; G_i++){
                G[G_i] = in.next();
            }
            int r = in.nextInt();
            int c = in.nextInt();
            String P[] = new String[r];
            for(int P_i=0; P_i < r; P_i++){
                P[P_i] = in.next();
            }
            findPattern(P, G);
        }
    }
    
    private static void findPattern(String[] needle, String[] haystack) {
        int pCols = needle[0].length();
        int pRows = needle.length;
        
        for(int row = 0 ; row < haystack.length ; row++) {
            for(int col = 0 ; col < haystack[row].length() ; col++) {
            	if(!(haystack[row].charAt(col) == needle[0].charAt(0)))
            		continue;
            	
                // get pattern string starting at this coordinate
            	boolean found = true;
            	for(int i = row; i < row + pRows ; i++) {
            		if(getSubstring(haystack[i%Math.max(1,row)], col, (col + pCols)%Math.max(1,col)).compareTo(needle[i-row]) != 0) {
            			found = false;
            			break;
            		}
            	}
                if(found) {
                	System.out.println("YES");
                	return;
                }
            }
        }
        System.out.println("NO");
    }
    
    private static String getSubstring(String st, int start, int end) {
    	if(end < start) {
    		StringBuilder newString = new StringBuilder();
    		newString.append(st.substring(start));
    		newString.append(st.substring(0, end));
    		return newString.toString();
    	}
    	return st.substring(start, end);
    }
}
