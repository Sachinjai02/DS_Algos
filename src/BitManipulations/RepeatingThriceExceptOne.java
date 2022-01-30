package BitManipulations;

/*
Problem Description
Given an array of integers, every element appears thrice except for one which occurs once.
Find that element which does not appear thrice.
NOTE: Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?

Problem Constraints
2 <= A <= 5*106
0 <= A <= INTMAX

Input Format: First and only argument of input contains an integer array A.
Output Format: Return a single integer.

Example Input
Input 1: A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Input 2: A = [0, 0, 0, 1]

Example Output
Output 1: 4
Output 2: 1
 */
public class RepeatingThriceExceptOne {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    //TC: O( Log max(A[i]) * A.length)
    public int singleNumber(final int[] A) {
        int uniqueNumber = 0;
        int maxSetBit = getMaxElementMaxSetBit(A);
        for(int i=0;i<maxSetBit;i++) {
            int numSetBitsAtIPos = 0;
            for(int j=0;j<A.length;j++) {
                if( (A[j] & (1<<i)) != 0) {
                    numSetBitsAtIPos++;
                }
            }
            if((numSetBitsAtIPos%3) != 0) {
                uniqueNumber = uniqueNumber | (1<<i);
            }
        }
        return uniqueNumber;
    }

    private int getMaxElementMaxSetBit(int[] A) {
        int max = A[0];
        for(int i=1;i<A.length;i++) {
            max = Math.max(A[i], max);
        }
        int maxSetBit = 0;
        while (max > 0) {
            maxSetBit++;
            max = max >> 1;
        }
        return maxSetBit;
    }
}
