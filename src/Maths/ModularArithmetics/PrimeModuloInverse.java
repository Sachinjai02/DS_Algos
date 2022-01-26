package Maths.ModularArithmetics;

/*
Problem Description
Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.
A-1 mod B is also known as modular multiplicative inverse of A under modulo B.

Problem Constraints
1 <= A <= 10^9
1<= B <= 10^9
B is a prime number
 */
public class PrimeModuloInverse {

    public int solve(int A, int B) {
        return pow(A, B-2, B);
    }

    public int pow(int A, int B, int C) {
        if(A==0) return 0;
        if(B==0) return 1;
        int halfpower = pow(A, B/2, C);
        int power = (int) ((halfpower * 1l * halfpower)%C);
        //odd
        if( (B & 1) != 0) {
            int aModC = A < 0 ? A%C + C : A%C ;
            power = (int) ((power * 1l * aModC)%C);
        }
        return power;
    }
}
