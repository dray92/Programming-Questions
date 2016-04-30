package leetcode;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class Convert_Sorted_Array_to_Binary_Search_Tree {

	public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
	
	private TreeNode helper(int[] nums, int left, int right) {
		if(left < 0 || left > right || right >= nums.length)
			return null;
		
		int mid = (left + right + 1)/2;
		
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, left, mid - 1);
		root.right = helper(nums, mid + 1, right);
		
		return root;
	}

	public static void main(String[] args) throws IOException {
		int[] arr = new int[]{0,1,2,3,4,5,6,7};
		TreeNode root = new Convert_Sorted_Array_to_Binary_Search_Tree().sortedArrayToBST(arr);
		OutputStreamWriter stream = new OutputStreamWriter(System.out);
		root.printTree(stream);
		stream.flush();
		stream.close();
	}
	
	public class TreeNode {
		Integer val;
		TreeNode left;
		TreeNode right;
		 
		TreeNode(int x) { 
			this.val = x; 
		}
		
		public String toString() {
			return String.valueOf(val);
		}
		
		public void printTree(OutputStreamWriter out) throws IOException {
	        if (right != null) {
	            right.printTree(out, true, "");
	        }
	        printNodeValue(out);
	        if (left != null) {
	            left.printTree(out, false, "");
	        }
	    }
	    private void printNodeValue(OutputStreamWriter out) throws IOException {
	        if (val == null) {
	            out.write("<null>");
	        } else {
	            out.write(val.toString());
	        }
	        out.write('\n');
	    }
	    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
	    private void printTree(OutputStreamWriter out, boolean isRight, String indent) throws IOException {
	        if (right != null) {
	            right.printTree(out, true, indent + (isRight ? "        " : " |      "));
	        }
	        out.write(indent);
	        if (isRight) {
	            out.write(" /");
	        } else {
	            out.write(" \\");
	        }
	        out.write("----- ");
	        printNodeValue(out);
	        if (left != null) {
	            left.printTree(out, false, indent + (isRight ? " |      " : "        "));
	        }
	    }
	}
}
