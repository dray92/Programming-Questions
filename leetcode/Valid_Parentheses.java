package leetcode;

import java.util.Stack;

public class Valid_Parentheses {
	
	public static boolean isValid(String s) {
		
        s = s.trim();
        if(s.length() % 2 != 0)
        	return false;
        
        Stack<Character> data = new Stack<Character>();
       
        for(int i = 0 ; i < s.length() ; i++) {
        	char ch = ' ';
        	if(!data.isEmpty())
        		ch = (Character) data.peek();
        	
        	char curChar = s.charAt(i);
        	switch(curChar) {
	        	case '(':
	        		data.push(curChar);
	    			break;
	        	case ')':
	        		if(ch != '(')
	        			return false;
	        		data.pop();
	    			break;
	        	case '{':
	        		data.push(curChar);
	    			break;
	        	case '}':
	        		if(ch != '{')
	        			return false;
	        		data.pop();
	    			break;
	        	case '[':
	        		data.push(curChar);
	    			break;
	        	case ']':
	        		if(ch != '[')
	        			return false;
	        		data.pop();
	    			break;
	    		default:
	    			return false;
    			
        	}
        }
        
		return data.isEmpty();
    }
	
	public static void main(String[] args) {
		String st = "()";
		System.out.println(st + " is valid? " + isValid(st));
		
		st = "((";
		System.out.println(st + " is valid? " + isValid(st));
	}
	
}
