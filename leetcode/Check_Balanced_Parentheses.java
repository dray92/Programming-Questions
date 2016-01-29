package leetcode;

import java.util.Stack;

/**
 * Given a string of opening and closing parentheses, check 
 * whether it’s balanced. We have 3 types of parentheses: 
 * round brackets: (), square brackets: [], and curly 
 * brackets: {}. Assume that the string doesn’t contain any 
 * other character than these, no spaces words or numbers. 
 * Just to remind, balanced parentheses require every 
 * opening parenthesis to be closed in the reverse order 
 * opened. For example ‘([])’ is balanced but ‘([)]’ is not.
 */
public class Check_Balanced_Parentheses {
	public boolean isBalanced(String st) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0 ; i < st.length() ; i++) {
			char ch = st.charAt(i);
			switch(ch) {
			case '(':
			case '{':
			case '[':
				stack.push(ch);
				break;
			case ')':
				if(stack.peek() != '(')
					return false;
				stack.pop();
				break;
			case '}':
				if(stack.peek() != '{')
					return false;
				stack.pop();
				break;
			case ']':
				if(stack.peek() != '[')
					return false;
				stack.pop();
				break;
			default:
				continue;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		Check_Balanced_Parentheses validParens = new Check_Balanced_Parentheses();
		String st = "({{{}}[])";
		System.out.println("String: " + st);
		System.out.println("Does it have valid parentheses? " + validParens.isBalanced(st));
	}
}
