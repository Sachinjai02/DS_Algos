package BitManipulations;

/*
Problem Description
Given an array of integers A, every element appears twice except for one. Find that single one.
NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Problem Constraints
2 <= |A| <= 2000000
0 <= A[i] <= INTMAX
Input Format
First and only argument of input contains an integer array A.
 */
public class SingleNumber {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    //TC: O(A.length)
    public int singleNumber(final int[] A) {
        int element = A[0];
        for(int i=1;i<A.length;i++) {
            element ^= A[i];
        }
        return element;
    }
}
