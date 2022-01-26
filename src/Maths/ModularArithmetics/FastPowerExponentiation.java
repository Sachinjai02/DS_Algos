package Maths.ModularArithmetics;

/*
Implement pow(x, n) % d.
In other words, given x, n and d,
find (x^n % d)

Note that remainders on division cannot be negative.
In other words, make sure the answer you return is non negative.
 */
public class FastPowerExponentiation {
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
