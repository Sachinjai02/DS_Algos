package Recursion;

/*
Problem Description
Given a number A, check if it is a magic number or not.
A number is said to be a magic number, if the sum of its digits are calculated
till a single digit recursively by adding the sum of the digits after every addition.
If the single digit comes out to be 1, then the number is a magic number.

Problem Constraints
1 <= A <= 10^9
 */
public class IsMagic {
    public int solve(int A) {
        return getSumAfterAddition(A) == 1 ? 1 : 0;
    }

    private int getSumAfterAddition(int A) {
        int sum = getSumAllDigits(A);
        if(sum < 10) return sum;
        return getSumAfterAddition(sum);
    }

    private int getSumAllDigits(int A) {
        if(A<10) return A;
        return A%10 + getSumAllDigits(A/10);
    }
}
