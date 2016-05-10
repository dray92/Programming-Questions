package leetcode;

public class Excel_Sheet_Column_Title {
	public String convertToTitle(int n) {
        StringBuilder st = new StringBuilder();
        while(n > 0) {
            n--;
            int v = n % 26;
            st.append((char)(v + 'A'));
            n /= 26;
        }
        return st.reverse().toString();
    }
}
