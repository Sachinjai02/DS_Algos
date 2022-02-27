package Hashing;

import java.util.HashSet;
import java.util.Set;

/**
 Problem Description
 Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
 If the given array contains a sub-array with sum zero return 1 else return 0.

 Problem Constraints:
 1 <= |A| <= 100000
 -10^9 <= A[i] <= 10^9
 Input Format:  The only argument given is the integer array A.
 Output Format:  Return whether the given array contains a subarray with a sum equal to 0.

 */
public class SubArrayZeroSum {
    public int solve(int[] A) {
        //Create a carry forward PF Sum and add it to Set
        Long carrySum = 0l;
        Set<Long> pfSumSets = new HashSet();
        for(int i=0;i<A.length;i++) {
            carrySum+=A[i];
            if(carrySum == 0) {
                return 1;
            }
            if(pfSumSets.contains(carrySum)) {
                return 1;
            }
            pfSumSets.add(carrySum);
        }

        return 0;
    }
}
