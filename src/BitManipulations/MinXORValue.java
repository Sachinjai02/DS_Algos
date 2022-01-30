package BitManipulations;

import java.util.Arrays;

/*
Problem Description:
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value.
Report the minimum XOR value.

Problem Constraints:
2 <= length of the array <= 100000
0 <= A[i] <= 10^9

Input Format: First and only argument of input contains an integer array A.
Output Format: Return a single integer denoting minimum xor value.

Example Input
Input 1: A = [0, 2, 5, 7]
Input 2: A = [0, 4, 7, 9]

Example Output
Output 1:2
Output 2:3
 */
public class MinXORValue {
    //Analyze bit arrangements for a sorted number arrangement
    // A <= B <= C
    // XOR(A,B) or XOR (B,C) will always be smaller than equal to XOR(A,C)
    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int minXor = A[0] ^ A[1];
        for(int i=1;i<A.length-1;i++) {
            minXor = Math.min(minXor, A[i] ^ A[i+1]);
        }
        return minXor;
    }
}
