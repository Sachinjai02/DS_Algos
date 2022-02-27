package Hashing;

import java.util.HashMap;
import java.util.Map;

/*
Problem Description
Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that
array as a special pair if elements at that index in the array are equal.
Shaggy wants you to find a special pair such that distance between that pair is minimum.
Distance between two indices is defined as |i-j|. If there is no special pair in the array then return -1.

Problem Constraints
1 <= |A| <= 10^5

Input Format
First and only argument is the array A.

Output Format
Return one integer corresponding to the minimum possible distance between a special pair.
 */
public class MinimumDiffForPairOfSameValue {

    public int solve(int[] A) {
        int minimumDistance = Integer.MAX_VALUE;
        Map<Integer, Integer> elementFirstOccurrenceIdx = new HashMap();
        for(int i=0;i<A.length;i++) {
            if(! elementFirstOccurrenceIdx.containsKey(A[i])) {
                elementFirstOccurrenceIdx.put(A[i], i);
            }
        }

        for(int i=0;i<A.length;i++) {
            int firstIdx = elementFirstOccurrenceIdx.get(A[i]);
            if(firstIdx != i) {
                minimumDistance = Math.min(minimumDistance, i-firstIdx);
            }
        }

        return minimumDistance != Integer.MAX_VALUE ? minimumDistance : -1;
    }
}
