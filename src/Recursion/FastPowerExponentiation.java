package Recursion;

/*
Implement pow(x, n) % d.
In other words, given x, n and d,
find (x^n % d)

Note that remainders on division cannot be negative.
In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.
*/
public class FastPowerExponentiation {
    public int pow(int A, int B, int C) {
        if(B == 0) return getMod(A,C);

        int halfPow = pow(A, B/2, C);
        int fullPow = getMod((long) halfPow * halfPow, C);

        if( (B&1) == 1) {
            fullPow = getMod((long) fullPow * A,C);
        }
        return fullPow;
    }

    private int getMod(long el, int mod) {
        int modVal = (int) (el%mod);
        if(modVal < 0) {
            modVal = modVal + mod;
        }
        return modVal;
    }
}
