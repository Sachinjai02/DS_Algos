package Maths.PrimeNumbers;
/*
Problem Description
Given an array of integers A, find and return the count of divisors of each element of the array.
NOTE: Order of the resultant array should be same as the input array.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 106

Input Format
The only argument given is the integer array A.

Output Format
Return the count of divisors of each element of the array in the form of an array.

Example Input
Input 1: A = [2, 3, 4, 5]
Input 2: A = [8, 9, 10]

Example Output
Output 1:[2, 2, 3, 2]
Output 2:[4, 3, 4]
 */
public class CountDivisors {
    //Prime factorization method
    // 1. smallest prime factors of all numbers from 1 to max A[i]: O(N*Log(LogN))
    // 2. divisor using spf : O(Log N)
    public int[] solve(int[] A) {
        int max = getMax(A);
        int[] spf = getSmallestPrimeFactors(max);
        int[] divisors = new int[A.length];
        for(int i=0;i<A.length;i++) {
            divisors[i] = countDivisors(A[i], spf);
        }
        return divisors;
    }

    private int getMax(int[] A) {
        int max = A[0];
        for(int i=1; i<A.length;i++) {
            if(A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }
    //TC: O(N* Log(Log N))
    private int[] getSmallestPrimeFactors(int N) {
        int[] spf = new int[N+1];
        for(int i=0;i<N+1;i++) {
            spf[i] = i;
        }

        for(int i=2;i*i<=N;i++) {
            if(spf[i] == i) {
                //its a prime number; mark its multiples starting from i*i till N to i
                for(int j = i*i;j<=N;j+=i) {
                    spf[j] = i;
                }
            }
        }
        return spf;
    }

    //Get division using prime factorization. TC: O(Log N)
    private int countDivisors(int element, int[] spf) {
        int divisors = 1;
        while (element > 1) {
            int smallestPrime = spf[element];
            int powersOfPrime = 0;
            while(element % smallestPrime == 0) {
                element = element/smallestPrime;
                powersOfPrime++;
            }
            divisors = divisors*(powersOfPrime+1);
        }
        return divisors;
    }
}
