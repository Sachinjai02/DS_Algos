package Hashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/*
Problem Description
Given two array of integers A and B, Sort A in such a way that the relative order among the elements
will be the same as those are in B. For the elements not present in B, append them at last in sorted order.
Return the array A after sorting from the above method.
NOTE: Elements of B are unique.

Problem Constraints
1 <= length of the array A <= 100000
1 <= length of the array B <= 100000
-10^9 <= A[i] <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.

Output Format
Return the array A after sorting as described.
 */
public class CustomSorting {
    public int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> elementsRank = new HashMap();
        for(int i=0;i<B.length;i++) {
            elementsRank.put(B[i], i);
        }

        return Arrays.stream(A).boxed().sorted(getCustomComparator(elementsRank)).mapToInt(i -> i).toArray();

    }

    private Comparator<Integer> getCustomComparator(HashMap<Integer, Integer> elementsRank) {
        return (a, b) -> {
            boolean isAinB = elementsRank.containsKey(a);
            boolean isBinB = elementsRank.containsKey(b);
            if(isAinB && isBinB) {
                return elementsRank.get(a) - elementsRank.get(b);
            } else if(isAinB) {
                return -1;
            } else if(isBinB) {
                return 1;
            } else {
                return a-b;
            }
        };

    }
}
