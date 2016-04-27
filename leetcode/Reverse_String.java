package leetcode;

public class Reverse_String {
	public String reverseString(String s) {
        if(s == null || s.length() == 0)
            return "";
        
        char[] st = s.toCharArray();
        
        for(int i = 0 ; i < st.length/2 ; i++) {
            st[i] ^= st[st.length - 1 - i];
            st[st.length - 1 - i] ^= st[i];
            st[i] ^= st[st.length - 1 - i];
        }
        
        return new String(st);
    }
}
