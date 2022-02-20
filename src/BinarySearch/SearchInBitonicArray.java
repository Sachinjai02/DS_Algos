package BinarySearch;

/*
Problem Description
Given a bitonic sequence A of N distinct elements,
write a program to find a given element B in the bitonic sequence in O(logN) time.

NOTE:
A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.

Problem Constraints
3 <= N <= 10^5
1 <= A[i], B <= 10^8

Given array always contain a bitonic point.
Array A always contain distinct elements.

Input Format
First argument is an integer array A denoting the bitonic sequence.
Second argument is an integer B.

Output Format
Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't exist in A return -1.
 */
public class SearchInBitonicArray {

    public int solve(int[] A, int B) {
        int length = A.length;
        //find the point of decreasing
        if(A[0] == B) return 0;
        if(A[length-1] == B) return length-1;

        int l=0, h=length-1, bitonic = 0;
        while(l<=h) {
            int mid = (l+h)/2;
            if(A[mid] > A[mid-1] && A[mid] > A[mid+1]) {
                bitonic = mid;
                break;
            } else if(A[mid] > A[mid-1]) {
                l = mid+1;
            } else {
                h = mid-1;
            }
        }

        if(A[bitonic] < B) return -1;

        //search in first half
        l=1; h=bitonic;
        while(l<=h) {
            int mid = (l+h)/2;
            if(B > A[mid]) {
                l=mid+1;
            } else if(B<A[mid]) {
                h=mid-1;
            } else {
                return mid;
            }
        }
        //search in second half
        l=bitonic+1; h=length-2;
        while(l<=h) {
            int mid = (l+h)/2;
            if(B > A[mid]) {
                h=mid-1;
            } else if(B<A[mid]) {
                l=mid+1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
