package Maths.PrimeNumbers;

import java.util.HashSet;
import java.util.Set;

/*
You have given an array A having N integers. Let say G is the product of all elements of A.
You have to find the number of distinct prime divisors of G.

Input Format
The first argument given is an Array A, having N integers.
Output Format

Return an Integer, i.e number of distinct prime divisors of G.

Constraints:
1 <= N <= 1e5
1 <= A[i] <= 1e5

Input: A = [1, 2, 3, 4]
Output: 2
 */
public class DistinctPrimes {
    //Find spf of max A[i] to find divisors of each A[i]; keep on adding divisors to a Set
    //Return the size of this Set
    public int solve(int[] A) {
        int max = getMax(A);
        int[] sps = getSps(max);
        Set<Integer> uniquePrimeDiv = new HashSet<>();
        for(int i=0;i<A.length;i++) {
            addUniquePrimeDivisors(A[i], sps, uniquePrimeDiv);
        }

        return uniquePrimeDiv.size();
    }

    private void addUniquePrimeDivisors(int el, int[] sps, Set<Integer> uniquePrimeDiv) {
        while(el > 1) {
            int primeDiv = sps [el];
            while(el % primeDiv == 0) {
                el = el/primeDiv;
            }
            uniquePrimeDiv.add(primeDiv);
        }
    }

    private int[] getSps(int el) {

        int[] sps = new int[el+1];
        for(int i=0;i<=el;i++) {
            sps[i] = i;
        }

        for(int i=2; i*i<= el;i++) {
            if(sps[i] == i) {
                //its a prime; mark other multiples with this smallest prime
                for(int j=i*i;j<=el;j+=i) {
                    sps[j] = Math.min(sps[j], sps[i]);
                }
            }
        }

        return sps;

    }

    private int getMax(int[] A) {
        int max = A[0];
        for(int i=1;i<A.length;i++) {
            if(A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

}
