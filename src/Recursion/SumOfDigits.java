package Recursion;

/*
Problem Description
Given a number A, we need to find sum of its digits using recursion.

Problem Constraints
1 <= A <= 10^9
 */
public class SumOfDigits {

    public int solve(int A) {
        if(A<10) return A;
        return A%10 + solve(A/10);
    }
}
