package BinarySearch;
/*
Problem Description
Given a matrix of integers A of size N x M in which each row is sorted.
Find and return the overall median of the matrix A.
NOTE: No extra memory is allowed.
NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.

Problem Constraints
1 <= N, M <= 10^5
1 <= N*M <= 10^6
1 <= A[i] <= 10^9
N*M is odd

Input Format
The first and only argument given is the integer matrix A.

Output Format
Return the overall median of the matrix A.
 */
public class MatrixMedian {
    public int findMedian(int[][] A) {
        //total of N*M elements which are odd number of elements
        //so find N*M/2 + 1 th smallest element
        int N=A.length, M= A[0].length;
        int l = A[0][0], h=l;
        for(int i=0;i<N;i++) {
            if(A[i][0] < l) {
                l=A[i][0];
            }
            if(A[i][M-1] > h) {
                h = A[i][M-1];
            }
        }

        int medianCount = (N * M + 1)/2, median =A[0][0];
        while(l<=h) {
            int mid = (l+h)/2;
            //search for number of elements in the matrix that are less than or equal to mid
            int count = countElementsSmallerThan(A, mid);
            //if count == medianCount then  mid is the probable median; search for better answer in left
            if(count == medianCount) {
                median = mid;
                h = mid-1;
            } else if(count > medianCount) {
                median = mid;
                h = mid-1;
            } else {
                l = mid+1;
            }
            //if count > medianCount high = mid-1;
            //if count < medianCount; low = mid+1;
        }
        return median;
    }

    //1 1 2 2 2 2
    private int countElementsSmallerThan(int[][] A, int el) {
        int numElements = 0;
        int N=A.length, M=A[0].length;
        for(int i=0;i<N;i++) {
            int l = 0, h=M-1, count = 0;
            while(l<=h) {
                int mid = (l+h)/2;
                if(A[i][mid] > el) {
                    h = mid-1;
                }else if(A[i][mid] < el) {
                    count = mid+1;
                    l = mid+1;
                } else {
                    count = mid+1;
                    l=mid+1;
                }

            }
            numElements +=count;
        }
        return numElements;
    }
}
