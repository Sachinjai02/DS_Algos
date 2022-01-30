package Maths.Combinatorics;

/*
Problem Description
Given three integers A, B and C, where A represents n, B represents r and C represents p
and p is a prime number greater than equal to n, find and return the value of nCr % p
where nCr % p = (n! / ((n-r)! * r!)) % p.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

NOTE: For this problem, we are considering 1 as a prime.

Problem Constraints
1 <= A <= 106
1 <= B <= A
A <= C <= 109+7
 */
public class NCRPrime {

    public int solve(int A, int B, int C) {
        //Edge cases
        if(C==1) return 0;
        if(C==B || A==B) return 1;

        /*
        NCr = ((n) * (n-1) * ... (n-r+1) ) / r!
        => NCr mod p = (((n) * (n-1) * ... (n-r+1) ) mod p * Inverse mod r!) mod p
        */

        int product = 1;
        for(int i=A;i>=A-B+1;i--) {
            product = (int) (((long)product*i) % C);
        }

        int factRInverseMod = getInverseModFactorial(B, C);
        return (int) (((long) product * factRInverseMod) % C);
    }

    // [r!] inverse mod p = [r!]^ (p-2) mod p = [r! mod p] ^ (p-2) mod p
    private int getInverseModFactorial(int factElement, int mod) {
        int rfactModP = 1;
        for(int i=2;i<=factElement;i++) {
            rfactModP = (int) (((long)rfactModP*i) % mod);
        }
        return fastPowExp(rfactModP, mod-2, mod);
    }

    private int fastPowExp(int el, int pow, int mod) {
        if(el == 1) return 1;
        if(pow == 0) return 1;
        int halfPower = fastPowExp(el, pow/2, mod);
        int power = (int) (((long) halfPower * halfPower)%mod);
        if((pow & 1) == 1) {
            power = (int) (((long)power * el)%mod);
        }
        return power;
    }
}
