package leetcode;

import java.util.Stack;
import java.util.StringTokenizer;

public class String_Expression {
	
	private static char[] charList = {'/', '*', '+', '-'};
	
	public static int solver(String s) {
		
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();
		
		StringTokenizer st = new StringTokenizer(s);
		
		s.replaceAll(" ", "");
		
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			
			// token is a number: push it onto the value stack
			if(isInteger(token)) {
				values.push(Integer.parseInt(token));
			} 
			
			// token is a left parenthesis: push it onto the operator stack
			else if (token.equals("(")) {
				ops.push(token.charAt(0));
			} 
			
			// token is a right parenthesis
			else if(token.equals(")")) {
				/*
				 * 1. While the thing on top of the operator stack is not 
				 * 	  a left parenthesis,
				 *    a. Pop the operator from the operator stack.
				 *    b. Pop the value stack twice, getting two operands.
				 *    c. Apply the operator to the operands, in the correct order.
				 *    d. Push the result onto the value stack.
				 * 2. Pop the left parenthesis from the operator stack, and discard it.
				 */
				while(ops.peek() != '(' || !ops.isEmpty())
					doOperation(ops, values);
				
				// popping left parenthesis
				if(ops.peek() != '(' || !ops.isEmpty()) 
					ops.pop();
			} 
			
			// token is an operation
			else if(isOp(token)) {
				/*
				 * 1. While the operator stack is not empty, and the top thing on the
   					  operator stack has the same or greater precedence as thisOp,
   				 *	  a. Pop the operator from the operator stack.
   				 *    b. Pop the value stack twice, getting two operands.
   				 *	  c. Apply the operator to the operands, in the correct order.
   	 			 *	  d. Push the result onto the value stack.
   	 			 * 2. Push thisOp onto the operator stack.
				 */
				while(!ops.isEmpty() && isGreater(ops.peek(), token.charAt(0))) 
					doOperation(ops, values);

				ops.push(token.charAt(0));
			} 
			
			// token is a bad/unhandled input
			else {
				System.out.println("Bad Input: " + token);
				return Integer.MIN_VALUE;
			}
		}
		
		/*
		 * While the operator stack is not empty, 
		 * 		1. Pop the operator from the operator stack. 
		 * 		2. Pop the value stack twice, getting two operands. 
		 * 		3. Apply the operator to the operands, in the correct order. 
		 * 		4. Push the result onto the value stack.
		 */
		while(!ops.isEmpty())
			doOperation(ops, values);

		/*
		 *	At this point the operator stack should be empty, and the value 
		 *	stack should have only one value in it, which is the final result.
		 */
		if(!ops.isEmpty()) {
			System.out.println("Bad Input: " + s); 
			return Integer.MIN_VALUE;
		}
		
		return values.pop();
	}
	
	private static void doOperation(Stack<Character> ops, Stack<Integer> values) {
		char operation = ops.pop();
		int op2 = values.pop();
		int op1 = values.pop();
		int result = getResult(op1, op2, operation);
		values.push(result);
	}
	
	private static int getResult(int op1, int op2, char operation) {
		switch(operation) {
			case '/':
				return op1/op2;
			case '*':
				return op1*op2;
			case '+':
				return op1+op2;
			case '-':
				return op1-op2;
			default:
				return 0;
		}
	}

	private static boolean isOp(String token) {
		for(char c: charList)
			if(token.charAt(0) == c)
				return true;
		
		return false;
	}

	private static boolean isInteger(String input)  {  
	   try {  
	      Integer.parseInt(input);  
	      return true;  
	   }  
	   catch(Exception e) {  
	      return false;  
	   }  
	} 
	
	private static boolean isGreater(char a, char b) {
		return indexOf(charList, a) <= indexOf(charList, b);
	}
	
	public static int indexOf(char[] arr,int value) {

        int k=0;
        for(int i = 0; i < arr.length ; i++){

            if(arr[i] == value){
                k = i;
                break;
            }
        }
        return k;
	}
	
	public static void main(String[] args) {
		String st = "4 + 5 * 10 + ( 5 + 6 )";
		System.out.println(st + " = " + solver(st));
	}
}
