package Maths.PrimeNumbers;
/*
Problem Description
Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
If there are more than one solutions possible, return the lexicographically smaller solution.
If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
[a, b] < [c, d], If a < c OR a==c AND b < d.
NOTE: A solution will always exist. Read Goldbach's conjecture.

Problem Constraints
4 <= A <= 2*10^7

Input Format
First and only argument of input is an even number A.

Output Format
Return a integer array of size 2 containing primes whose sum will be equal to given number.

Example Input: 4
Example Output: [2, 2]
 */
public class PrimeSumOfEvenNumber {

    //Get sieve of eratosthenes prime  (A+1) -> TC: O(N*Log(Log N))
    //O(N) : iterate from 2 to N and check if i and A-i are both prime ; when found return
    public int[] primesum(int A) {
        int[] output = new int[2];
        boolean[] primes = getPrimes(A);
        for(int i=2;i<A;i++) {
            if(primes[i] && primes[A-i]) {
                output[0] = i;
                output[1] = A-i;
                break;
            }
        }
        return output;
    }

    private boolean[] getPrimes(int N) {
        boolean[] primes = new boolean[N+1];
        for(int i=2; i<=N;i++) {
            primes[i] = true;
        }
        for(int i=2;i*i<=N;i++) {
            if(primes[i]) {
                for(int j=i*i;j<=N;j+=i) {
                    primes[j] = false;
                }
            }
        }

        return primes;
    }
}
