package BinarySearch;

/*
Problem Description

Given a sorted array A of size N and a target value B,
return the index (0-based indexing) if the target is found.
If not, return the index where it would be if it were inserted in order.

NOTE: You may assume no duplicates in the array.
Users are expected to solve this in O(log(N)) time.

Problem Constraints
1 <= N <= 10^6

Input Format:
First argument is an integer array A of size N.
Second argument is an integer B.

Output Format:
Return an integer denoting the index of target value.
 */
public class SortedInsertPosition {

    public int searchInsert(int[] A, int B) {
        int result = -1;
        int l =0, h=A.length-1;
        while(l<=h) {
            int m = (l+h)/2;
            if(A[m] == B) {
                result = m;
                break;
            } else if(A[m] > B) {
                h = m-1;
            } else {
                l = m+1;
            }
        }
        return result != -1 ? result : l;
    }
}
