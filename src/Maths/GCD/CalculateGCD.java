package Maths.GCD;
/*
Given 2 non negative integers A and B, find gcd(A, B)
GCD of 2 integers A and B is defined as the greatest integer g such that g is a divisor of both A and B. Both A and B fit in a 32 bit signed integer.
Note: DO NOT USE LIBRARY FUNCTIONS.

Problem Constraints
0 <= A, B <= 10^9

Input Format
First argument is an integer A.
Second argument is an integer B.

Output Format
Return an integer denoting the gcd(A, B).

Example Input

Input 1:
A = 4
B = 6

Input 2:
A = 6
B = 7

Example Output
Output 1: 2
Output 2: 1

 */
public class CalculateGCD {

    //TC: O(min(A, B))
    public int gcd1(int A, int B) {
        int min = Math.min(A, B);
        if(min == 0) return Math.max(A,B);
        for(int i=min;i>0;i++) {
            if(A%i==0 && B%i==0) {
                return i;
            }
        }
        return 1;
    }

    //TC: O(sqrt(Min(A,B)))
    public int gcd2(int A, int B) {
        int min = Math.min(A, B);
        if(min == 0) return Math.max(A,B);
        int gcd = 1;
        for(int i=1;i*i<=min;i++) {
            int factor = i;
            if(min%factor == 0) {
                if(A%factor==0 && B%factor==0) {
                    gcd = Math.max(gcd, factor);
                }
                factor = min/i;
                if(A%factor==0 && B%factor==0) {
                    gcd = Math.max(gcd, factor);
                }
            }
        }
        return gcd;
    }

    //TC: O(Log(max(A,B)))
    public int gcd(int A, int B) {
        if(B==0) return A;
        return gcd(B, A%B);
    }
}
