package hackerRank;

import java.util.Scanner;
import java.util.Stack;

/**
 * A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"

Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not. 
 * @author Debosmit
 *
 */
public class Java_Stack {
	
	public static void main(String []argh){
		Scanner sc = new Scanner(System.in);
  
		while (sc.hasNext()) {
			String input=sc.next();
			
			System.out.println(isBalanced(input));
		}
      
	}

	private static boolean isBalanced(String input) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0 ; i < input.length() ; i++) {
			char c = input.charAt(i);
			if(c == ')' || c == '}' || c == ']') {
				if(stack.isEmpty())
					return false;
				Character stackTop = stack.pop();
				if( (c == ')' && stackTop != '(') || (c == '}' && stackTop != '{') || (c == ']' &&  stackTop != '[') )
					return false;			
			} else 
				stack.push(c);
		}
		
		if(!stack.isEmpty())
			return false;
		
		return true;
	}
}
