package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a 
 * function to generate all combinations 
 * of well-formed parentheses. 
 * @author Debosmit
 *
 */
public class Generate_Parentheses {

	public List<String> generateParenthesis(int n) {
		List<String> parens = new ArrayList<String>();
		generateParenthesis(parens, new StringBuilder(), n, n);
		return parens;
    }

	private void generateParenthesis(List<String> parens,
			StringBuilder sb, int left, int right) {
		
		// too many right parentheses inserted
		if(left > right)
			return;
		
		// one string obtained
		if(left == 0 && right == 0) {
			parens.add(sb.toString());
			return;
		}
		
		// more priority to add left
		if(left > 0) {
			sb.append("(");
			generateParenthesis(parens, sb, left-1, right);
			sb.deleteCharAt(sb.length()-1);
		}
		
		if(right > 0) {
			sb.append(")");
			generateParenthesis(parens, sb, left, right-1);
			sb.deleteCharAt(sb.length()-1);
		}
	}	
	
	public static void main(String[] args) {
		Generate_Parentheses Parens = new Generate_Parentheses();
		
		List<String> parens = Parens.generateParenthesis(3);
		System.out.println(parens);
	}
}
