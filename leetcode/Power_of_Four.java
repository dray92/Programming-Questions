package leetcode;

public class Power_of_Four {
	public boolean isPowerOfFour(int num) {
        return num >= 0 && (num & (num-1)) == 0 && (num-1) % 3 == 0;
    }
}
