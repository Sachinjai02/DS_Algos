package Maths.ModularArithmetics;

/**
 Problem Description
 Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
 "^" means power ,
 "%" means "mod", and
 "!" means factorial.

 Problem Constraints
 1 <= A, B <= 5e5

 Input Format
 First argument is the integer A
 Second argument is the integer B

 Output Format: Return one integer, the answer to the problem
 */
public class VeryLargeNumberPower {

    /*
   In general, A Inverse mod M can be said to B and can be calculated
   if gcd(A, B) = 1 and B -> [1,m-1] such that (A*B) mod M = 1
   Fermat's theorem:
   Given the fact p is a prime number and A%p !=0:
   1. A^(p-1) mod p = 1;
   2. A inverse mod p = A^(p-2) mod p

   1e9+7 is a prime number;
   B! = Q*(p-1) + r;
   A^ B! = A^ Q*(p-1) * A ^ r
   => (A ^ B!) mod p = 1 * (A ^ r) mod p
   where r = B! % (p-1)
   */
    // TC : O(B + Log p)
    public int solve1(int A, int B) {
        int p = 1000000007;
        int r = 1;
        for(int i=2;i<=B;i++) {
            r = (int) (((long) r*i)%(p-1));
        }
        return pow(A, r, p);
    }
    //TC : O(B*Log(B))
    public int solve2(int A, int B) {
        int modVal = 1000000007;
        int answer = A%modVal;
        for(int p=2;p<=B;p++) {
            answer = pow(answer, p, modVal);
        }
        return answer;
    }

    public int pow(int A, int B, int C) {
        if(B==0) return 1;
        int halfpower = pow(A, B/2, C);
        int power = (int) (((long) halfpower * halfpower)%C);
        //odd
        if( B%2 ==1) {
            power = (int) (((long) power * A)%C);
        }
        return power;
    }
}
