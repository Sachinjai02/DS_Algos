package Maths.ModularArithmetics;

/*
Problem Description
Given two integers A and B, find the greatest possible positive M, such that A % M = B % M.

Problem Constraints
1 <= A, B <= 109
A != B
 */
public class ABModulo {
    public int solve(int A, int B) {
        int small = Math.min(A, B);
        int large = Math.max(A, B);
        int factorsOfReqd = large-small;
        return factorsOfReqd;
    }
}
