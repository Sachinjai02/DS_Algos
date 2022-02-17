package BinarySearch;

/*
Problem Description
Given an array of integers A, find and return the peak element in it.
An array element is peak if it is NOT smaller than its neighbors.
* A can have duplicates
* If no peak is to be found then return 0
For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time.

Problem Constraints

1 <= |A| <= 100000

1 <= A[i] <= 10^9


Input Format
The only argument given is the integer array A.
Output Format
Return the peak element.
 */
public class FindPeak {
    public int solve(int[] A) {
        //edge case with only 1 element
        if(A.length == 1) return A[0];
        //edge case with corner elements being the peak
        if(A[0] >= A[1]) return A[0];
        if(A[A.length-1] >= A[A.length-2]) return A[A.length-1];

        int l = 1, h = A.length-2;

        while(l<=h) {
            int mid = (l+h)/2;
            if(A[mid] >= A[mid+1] && A[mid] >= A[mid-1]) {
                return A[mid];
            } else if(A[mid] < A[mid-1]) {
                h=mid-1;
            } else {
                l = mid+1;
            }
        }
        return 0;
    }
}
