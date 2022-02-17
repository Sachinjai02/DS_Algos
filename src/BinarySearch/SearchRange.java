package BinarySearch;

/*
Problem Description
Given a sorted array of integers A(0 based index) of size N,
find the starting and ending position of a given integer B in array A.

Your algorithm's runtime complexity must be in the order of O(log n).

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A,
 if B is not found in A return [-1, -1].

Problem Constraints
1 <= N <= 10^6

1 <= A[i], B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.
 */
public class SearchRange {

    public int[] searchRange(final int[] A, int B) {
        int start = Integer.MIN_VALUE;

        int l=0, h=A.length-1;
        while(l<=h) {
            int mid = (l+h)/2;
            if(A[mid] > B) {
                h=mid-1;
            } else if(A[mid] < B ) {
                l=mid+1;
            } else {
                start = mid;
                h=mid-1;
            }
        }

        if(start == Integer.MIN_VALUE) {
            return new int[]{-1,-1};
        }

        int end = start;
        l=start;
        h=A.length-1;
        while(l<=h) {
            int mid = (l+h)/2;
            if(A[mid] > B) {
                h=mid-1;
            } else if(A[mid] < B ) {
                l=mid+1;
            } else {
                end = mid;
                l=mid+1;
            }
        }

        return new int[]{start,end};
    }
}
