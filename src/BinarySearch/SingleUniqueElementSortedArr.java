package BinarySearch;

/*
Problem Description

Given a sorted array of integers A where every element appears twice
except for one element which appears once, find and return this single element that appears only once.

NOTE: Users are expected to solve this in O(log(N)) time.


Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the single element that appears only once.
 */
public class SingleUniqueElementSortedArr {

    public int solve(int[] A) {
        int length = A.length;
        if(length==1) return A[0];

        if(A[0] != A[1]) return A[0];
        if(A[length-1] != A[length-2]) return A[length-1];

        int l = 2, h = length-3;
        while(l <= h) {
            int mid = (l+h)/2;
            if(A[mid] != A[mid-1] && A[mid] != A[mid+1]) {
                return A[mid];
            } else if(A[mid] == A[mid-1]) {
                //landed on second occurrence of same element
                if( (mid & 1) == 0) {
                    h = mid-2;
                } else {
                    l = mid+1;
                }
            } else {
                //landed on first occurrence of same element
                if( (mid & 1) == 0) {
                    l = mid+2;
                } else {
                    h = mid-1;
                }
            }
        }

        return 0;
    }
}
