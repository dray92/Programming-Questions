package hackerRank;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/maximum-element
 * 
 * @author Debosmit
 *
 */
public class Maximum_Element {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = Integer.MIN_VALUE;
		Stack<StackNode> stack = new Stack<StackNode>();
		
		while (n > 0) {
			int choice = sc.nextInt();
			if(choice == 1) {
				int val = sc.nextInt();
				max = Math.max(val, max);
				
				stack.add(new StackNode(val, max));
			} else if(choice == 2) {
				if(!stack.isEmpty())
					stack.pop();
				// reset max
				if(stack.isEmpty())
					max = Integer.MIN_VALUE;
				else
					max = stack.peek().curMax;
			} else if(choice == 3) {
				if(!stack.isEmpty()) {
					System.out.println(stack.peek().curMax);
				}
			}
			
			n--;
		}
		sc.close();
	}
	private static class StackNode {
		int val;
		int curMax;
		public StackNode(int val, int curMax) {
			this.val = val;
			this.curMax = curMax;
		}
		
		public String toString() {
			return val + " [" + curMax + "]";
		}
	}
}
