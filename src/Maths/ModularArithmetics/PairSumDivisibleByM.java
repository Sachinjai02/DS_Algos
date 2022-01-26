package Maths.ModularArithmetics;

import java.util.HashMap;

/*
Problem Description
Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
Since the answer may be large, return the answer modulo (10^9 + 7).

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^6

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).

Example Input
Input 1: A = [1, 2, 3, 4, 5]
        B = 2
Input 2: A = [5, 17, 100, 11]
         B = 28

Example Output
Output 1: 4
Output 2: 1
 */
public class PairSumDivisibleByM {

    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> modularCounts = new HashMap();
        int pairs = 0;
        int modVal = 1000000007;

        for(int i=0;i<B;i++) {
            modularCounts.put(i,0);
        }

        for(int i=0;i<A.length;i++) {
            int elementModB = A[i]%B;
            Integer elementModBCount = modularCounts.get(elementModB);
            modularCounts.put(elementModB, elementModBCount+1);
        }

        pairs = (int)(modularCounts.get(0) * (long) (modularCounts.get(0) -1)/2)%modVal;
        if(B%2==0) {
            pairs = (int) ( (long)pairs + ((long) modularCounts.get(B/2)  * (modularCounts.get(B/2) -1)/2))%modVal;
        }
        int i=1,j=B-1;
        while(i<j) {
            pairs = (int) (pairs + (long) modularCounts.get(i)*modularCounts.get(j))%modVal;
            i++;
            j--;
        }
        return pairs;
    }
}
