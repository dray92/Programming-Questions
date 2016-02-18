package randomCode;

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
	    
	    public static void main(String args[]) {
	    	Solution2 sj = new Solution2();
	    	String st = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
	    	sj.solution(st);
	    }
	}