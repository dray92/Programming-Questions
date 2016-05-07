package leetcode;

public class Range_Sum_Query_Immutable {
	private int numsCum[];

    public Range_Sum_Query_Immutable(int[] nums) {
        this.numsCum = nums;
        for(int i = 1 ; i < numsCum.length ; i++)
            numsCum[i] += numsCum[i-1];
    }

    public int sumRange(int i, int j) {
        if(i == 0)
            return numsCum[j];
        return numsCum[j] - numsCum[i-1];
    }
}
