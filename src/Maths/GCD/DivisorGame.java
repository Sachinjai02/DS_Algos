package Maths.GCD;

/*
Problem Description
Scooby has 3 three integers A, B and C.
Scooby calls a positive integer special if it is divisible by B and it is divisible by C. You need to tell number of special integers less than or equal to A.

Problem Constraints
1 <= A, B, C <= 109

Input Format
First argument is a positive integer A
Second argument is a positive integer B
Third argument is a positive integer C

Output Format
One integer corresponding to the number of special integers less than or equal to A.

Example Input
Input 1:
 A = 12
 B = 3
 C = 2
Input 2:
 A = 6
 B = 1
 C = 4


Example Output:
Output 1: 2
Output 2: 1
 */
public class DivisorGame {

    public int solve(int A, int B, int C) {
        long divisor = (B*C) / gcd(B,C);
        return (int) (A/divisor);
    }

    private int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
