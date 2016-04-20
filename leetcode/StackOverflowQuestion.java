package leetcode;

import java.util.Stack;

/**
 * Input: (a(b()())(c(d()())())) 
 * Output:  a b 
 *			a c d  
 *
 * http://stackoverflow.com/questions/36467325/how-do-i-transverse-this-binary-tree-using-recursion
 * @author Debosmit
 *
 */
public class StackOverflowQuestion {
	
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<Character>();
		String st = "(a(b()())(c(d()())()))";
		String parent = null;
		for(int i = 0 ; i < st.length() ; i++) {
			char c = st.charAt(i);
			
			if(c != ')') {
				
				// if it is an alphabet
				if(c != '(')  {
					// will require printing of parents, iff there are more characters to print
					if(parent != null) {
						System.out.print(parent);
						parent = null;
					}
					System.out.print(c + " ");
				}
				stack.push(c);
			} else {
				// is the character on top a matching opening bracket?
				// if it is, then nothing to do, if not 
				char curTop = stack.pop();
				if(curTop != '(') 
					while(curTop != '(')
						curTop = stack.pop();
				else 
					continue;
				
				// done working with a character; move to next line
				System.out.println();
				
				// now, need to reprint the `a` portion
				Stack<Character> temp = new Stack<Character>();
				while(!stack.isEmpty())
					temp.push(stack.pop());
				
				while(!temp.isEmpty()) {
					Character ch = temp.pop();
					if( !(ch == '(' || ch == ')') ) {
						// store content
						if(parent == null)
							parent = "";
						parent += ch + " ";
					}
						
					stack.push(ch);
				}
				
			}
		}
	}
}
