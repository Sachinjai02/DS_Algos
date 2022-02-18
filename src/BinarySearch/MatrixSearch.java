package BinarySearch;

/*
Problem Description
Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.

This matrix A has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.
NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.

Problem Constraints
1 <= N, M <= 1000
1 <= A[i][j], B <= 10^6

Input Format
The first argument given is the integer matrix A.
The second argument given is the integer B.

Output Format
Return 1 if B is present in A, else return 0.

Example Input
Input 1:
A = [
      [1,   3,  5,  7]
      [10, 11, 16, 20]
      [23, 30, 34, 50]
    ]
B = 3
Input 2:
A = [
      [5, 17, 100, 111]
      [119, 120, 127, 131]
    ]
B = 3

Example Output
Output 1:1
Output 2:0
 */
public class MatrixSearch {

    public int searchMatrix(int[][] A, int B) {
        int N = A.length;
        int M = A[0].length;
        int r=0, c=M-1;

        while(r < N && c>=0) {
            if(A[r][c] == B) return 1;
            else if(A[r][c] > B) {
                c--;
            } else {
                r++;
            }
        }
        return 0;
    }
}
