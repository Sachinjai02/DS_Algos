package Maths.PrimeNumbers;

/*
Given an array A having N positive numbers. You have to find the number of Prime subsequences of A.
A Prime subsequence is one that has only prime numbers, for example [2, 3], [5] are the Prime subsequences where [2, 4] and [1, 2, 3, 4] are not.

Input Format
The first argument given is an Array A, having N integers.
Output Format
Return an integer X, i.e number of Prime subsequences.
As X can be very large print X % (1000000007), here % is modulus operator.

Constraints
1 <= N <= 1e3
1 <= A[i] <= 1e6
 */
public class PrimeSubsequences {
    //TC: O(A.length + Max(A[i]) *(Log(Log(Max(A[i]))) )
    public int solve(int[] A) {
        int maxVal = getMax(A);
        boolean[] primes = getPrimes(maxVal);
        int count = 1;
        int modVal = 1000000007;
        for(int i=0;i<A.length;i++) {
            if(primes[A[i]]) {
                count = (int) (((long)count * 2)%modVal);
            }
        }
        return (count-1)%modVal;
    }

    private int getMax(int[] A) {
        int max = A[0];
        for(int i=1;i < A.length; i++) {
            if(max < A[i]) {
                max = A[i];
            }
        }
        return max;
    }

    private boolean[] getPrimes(int N) {
        boolean[] primes = new boolean[N+1];
        for(int i=2;i<=N;i++) {
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
