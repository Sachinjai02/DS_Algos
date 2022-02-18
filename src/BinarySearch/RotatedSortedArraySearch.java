package BinarySearch;

/*
Problem Description:
Given a sorted array of integers A of size N and an integer B.
array A is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
You are given a target value B to search.
If found in the array, return its index, otherwise return -1.
You may assume no duplicate exists in the array.
NOTE: Users are expected to solve this in O(log(N)) time.

Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 10^9
all elements in A are distinct.

Input Format:
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format: Return index of B in array A, otherwise return -1
 */
public class RotatedSortedArraySearch {

    public int search(final int[] A, int B) {
        //0 1 2 4 5 6 7
        //4 5 6 7 0 1 2
        //7 6 5 4 2 1 0
        //finding the pivot point
        int l=0, h = A.length-1, k=0;
        while(l<=h) {
            int mid = (l+h)/2;
            if(mid != (A.length-1) && A[mid+1] < A[mid]) {
                k=mid+1; break;
            } else if(A[mid] > A[0]) {
                l=mid+1;
            } else {
                h=mid-1;
            }
        }
        l=0; h=A.length-1;
        if(A[0] == B) return 0;
        //if k==0 then the entire array is either sorted increasing /decreasing meaning search
        //across the entire array
        else if(k!=0) {
            if(A[0] < B) {
                //means target element in first sorted array [0,k-1]
                h=k-1;
            } else {
                //means target element in second sorted array [k,N-1]
                l=k;
            }
        }
        //Doing normal Binary search
        while(l<=h) {
            int mid = (l+h)/2;
            if(A[mid]==B) return mid;
            else if (A[mid] > B) {
                h=mid-1;
            } else {
                l=mid+1;
            }
        }
        return -1;
    }
}
