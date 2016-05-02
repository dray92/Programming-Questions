package leetcode;

public class Power_of_Three {

	// http://stackoverflow.com/questions/1804311/how-to-check-if-an-integer-is-a-power-of-3/36981616#36981616
	public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
