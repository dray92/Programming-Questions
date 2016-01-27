package ctci;

import java.util.ArrayList;

/** 
 * Print all valid combinations of 
 * n pairs of parentheses.
 * @author Debosmit
 *
 */
public class RecursionDP9_6 {

	private void generateParens(ArrayList<String> list, int leftRem,
			 int rightRem, StringBuilder sb, int index) {
		
		// number of left parentheses remaining cannot be less than 0
		// cannot possibly have a valid string having inserted more
		// right parentheses than left parentheses
		if(leftRem < 0 || rightRem < leftRem)
			return;
		
		if(leftRem == 0 && rightRem == 0)
			list.add(sb.toString());
		
		
		else {
			// add left parenthesis if any left
			if(leftRem > 0) {
				try {
					sb.setCharAt(index, '(');
				} catch(Exception e) {
					sb.insert(index, "(");
				}
				generateParens(list, leftRem-1, rightRem, sb, index+1);
			}
			
			// add right parenthesis if valid
			if(rightRem > leftRem) {
				try {
					sb.setCharAt(index, ')');
				} catch(Exception e) {
					sb.insert(index, ")");
				}
				generateParens(list, leftRem, rightRem-1, sb, index+1);
			}
		}
	}
	
	public ArrayList<String> generateParens(int count) {
		StringBuilder sb = new StringBuilder(2*count);
		ArrayList<String> list = new ArrayList<String>();
		generateParens(list, count, count, sb, 0);
		return list;
	}

	public static void main(String[] args) {
		RecursionDP9_6 parens = new RecursionDP9_6();
		int numPairs = 2;
		ArrayList<String> list = parens.generateParens(numPairs);
		
		for(String st: list) 
			System.out.println(st);
		
	}
}
