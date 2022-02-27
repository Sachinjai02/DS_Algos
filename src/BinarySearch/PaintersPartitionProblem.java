package BinarySearch;

/*
Problem Description
Given 2 integers A and B and an array of integers C of size N.
Element C[i] represents length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1].
There are A painters available and each of them takes B units of time to paint 1 unit of board.

Calculate and return minimum time required to paint all boards under the constraints
that any painter will only paint contiguous sections of board.
NOTE:
1. 2 painters cannot share a board to paint.
That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards.
Which means a configuration where painter 1 paints board 1 and 3 but not 2 is invalid.
Return the ans % 10000003.

Problem Constraints
1 <= A <= 1000
1 <= B <= 106
1 <= N <= 105
1 <= C[i] <= 106

Input Format
The first argument given is the integer A.
The second argument given is the integer B.
The third argument given is the integer array C.

Output Format
Return minimum time required to paint all boards under the constraints
that any painter will only paint contiguous sections of board % 10000003.
 */
public class PaintersPartitionProblem {
    public int paint(int A, int B, int[] C) {
        long hi = C[0], lo = C[0];
        for(int i=1;i<C.length;i++) {
            hi += C[i];
            if(lo < C[i]) {
                lo = C[i];
            }
        }
        Long numUnits = 0l;
        while(lo <= hi) {
            long m = (lo + hi)/2;
            if(checkIfAllPaintersCanPaint(C, A, m)) {
                numUnits = m;
                hi = m-1;
            } else {
                lo = m+1;
            }
        }

        return (int) ((numUnits * B)%10000003);
    }

    private boolean checkIfAllPaintersCanPaint(int[] boards, int numPainters, long minBoardUnits) {
        int countBoardUnits = 0, countPainters = 0;
        for(int i=0;i<boards.length;i++) {
            if(boards[i] > minBoardUnits) {
                return false;
            }
            countBoardUnits += boards[i];
            if(countBoardUnits > minBoardUnits) {
                countPainters++; countBoardUnits = boards[i];
            }
        }
        if(countBoardUnits > 0) countPainters++;
        if(countPainters <= numPainters) return true;
        return false;
    }

}
