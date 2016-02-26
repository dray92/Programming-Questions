package randomCode;

import java.util.ArrayList;
import java.util.Arrays;

class Solution2 {
	   
	   public int solution(String S) {
	        // write your code in Java
	        String[] elements = S.split("\n");
	        
	        int sum = 0;
	        for(int i = elements.length - 1 ; i >= 0 ; i-- ) {
	            if(isImage(elements[i])) {
	                int numSpaces = numSpaces(elements[i]);
	                // image at root
	                if(numSpaces == 0) {
	                    sum += elements[i].length() + 1;    // 1 for slash
	                } else {
	                    int spaces = numSpaces - 1;
	                    
	                    while(spaces >= 0) {
	                    // direct parent must have numSpaces-1 spaces at front
	                    
	                    // root has 0 spaces in front
	                    // need to keep moving up till received parent has 
	                    // 0 spaces in the front
	                        sum += getParent(elements, i, spaces) + 1;  // 1 for slash
	                        spaces--;
	                    }
	                }
	            }
	        }
	        return sum;
	    }
	    
	    private int getParent(String[] elems, int curIndex, int parentSpaces) {
	        for(int i = curIndex - 1 ; i >= 0 ; i--) {
	            int spaces = numSpaces(elems[i]);
	            // found direct parent
	            if(spaces == parentSpaces)
	                return elems[i].length() - spaces;
	        }
	        return 1;
	    }
	    
	    // image exts
	    private final String[] imgs = {".jpeg", ".png", ".gif"};
	    
	    // returns if filename is an image
	    private boolean isImage(String st) {
	        for(String ext: imgs) {
	            if(st.endsWith(ext))
	                return true;
	        }
	        return false;
	    }
	    
	    // returns num spaces at the beginning of string
	    private int numSpaces(String st) {
	        int count = 0;
	        int index = 0;
	        while(index < st.length()) {
	            if(st.charAt(index) == ' ')
	                count++;
	            else
	                break;
	            index++;
	        }
	        return count;
	    }
	    
	    private static void transpose(int[][] m) {

	        for (int i = 0; i < m.length; i++) {
	            for (int j = i; j < m[0].length; j++) {
	                int x = m[i][j];
	                m[i][j] = m[j][i];
	                m[j][i] = x;
	            }
	        }
	    }

	    private static void swapRows(int[][] m) {
	        for (int i = 0, k = m.length - 1; i < k; ++i, --k) {
	            int[] x = m[i];
	            m[i] = m[k];
	            m[k] = x;
	        }
	    }
	    
	    public void inserts(int[] bytes) {
	    	int len = bytes.length;
	    	// check if square 
	    	if((len & (len-1)) != 0)
	    		throw new IllegalArgumentException("Can't make an NxN array from bytes");
	    }
	    
	    public static void main(String args[]) {
	    	Solution2 sj = new Solution2();
	    	String st = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
	    	sj.solution(st);
	    	
	    	ArrayList<byte[]> arr = new ArrayList<byte[]>(9);
	    	initialize(arr);
	    	
	    	printRows(arr);
	    	
	    	arr = transpose(arr);
	    	printRows(arr);
	    	
	    }
	    
	    private static ArrayList<byte[]> transpose(ArrayList<byte[]> arr) {
	    	ArrayList<byte[]> newArr = new ArrayList<byte[]>(9);
	    	for(int i = 0 ; i < 9 ; i++)
	    		newArr.add(null);
	    	
	    	for(int row = 0; row < 3 ; row++) {
	    		for(int col = 0 ; col < 3 ; col++) {
	    			if(row == col) {
	    				newArr.add(row + 3*col, arr.get(row + 3*col));
	    			}
	    			
	    			int second = row + 3*col;	// elem at (row,col)
	    			int first = 3*row + col;	// elem at (col,row)
	    			
	    			// swap
	    			newArr.set(first, arr.get(second));
	    			newArr.set(second, arr.get(first));	
	    		}
	    	}
	    	
	    	return newArr;
	    }
	    
	    private static void initialize(ArrayList<byte[]> arr) {
			for(byte i = 0 ; i < 9 ; i++) {
				byte[] a = {i,i,i,i};
				arr.add(a);
			}
		}

		private static void printRows(ArrayList<byte[]> arr) {
			int row = 0;
	    	for(int i = 0 ; i < arr.size() ; i++) {
	    		System.out.print(Arrays.toString(arr.get(i)) + "  ");
	    		row++;
	    		if(row%3 == 0)
	    			System.out.println();
	    	}
	    	System.out.println("\n\n");
	    }
	}