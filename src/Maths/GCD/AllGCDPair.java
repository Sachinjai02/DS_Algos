package Maths.GCD;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Problem Description
Given an array of integers A of size N containing GCD of every possible pair of elements of another array.
Find and return the original numbers which are used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.

Problem Constraints
1 <= N <= 10000
1 <= A[i] <= 10^9

Input Format
The first and only argument given is the integer array A.

Output Format
Find and return the original numbers which are used to calculate the GCD array in any order.

Example Input
Input 1:
 A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
Input 2:
 A = [5, 5, 5, 15]

Example Output
Output 1:[2, 8, 10]
Output 2:[5, 15]
 */
public class AllGCDPair {

    public int[] solve(int[] A) {
        int sizeOriginalArr = getSqrt(A.length);
        int[] originalArr = new int[sizeOriginalArr];
        int numberElementsFilled = 0;
        HashMap<Integer, Integer> gcdPairFreq = new HashMap();
        for(int i=0;i<A.length;i++) {
            Integer occurrence = gcdPairFreq.get(A[i]);
            if(occurrence == null) occurrence = 0;
            gcdPairFreq.put(A[i], occurrence+1);
        }

        while(numberElementsFilled < sizeOriginalArr) {
            int nextLargestElement = findMax(gcdPairFreq);
            decreaseFrequency(gcdPairFreq, nextLargestElement, 1);
            originalArr[numberElementsFilled] = nextLargestElement;
            numberElementsFilled++;
            for(int i=numberElementsFilled-2;i>=0;i--) {
                int gcdOfCurrentAndPrev = gcd(nextLargestElement, originalArr[i]);
                decreaseFrequency(gcdPairFreq, gcdOfCurrentAndPrev, 2);
            }
        }

        return originalArr;

    }

    private int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }

    private void decreaseFrequency(Map<Integer,Integer> map, int el, int decrementCount) {
        int currentFreq = map.get(el);
        map.put(el, currentFreq-decrementCount);
    }

    private int findMax(Map<Integer, Integer> map) {
        int max = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int currentValFreq = entry.getValue();
            int currentVal = entry.getKey();
            if(currentValFreq > 0 && currentVal > max) {
                max = currentVal;
            }
        }
        return max;
    }

    private int getSqrt(int n) {
        for(int i=1;i*i<=n;i++) {
            if(i*i == n) {
                return i;
            }
        }
        return 0;
    }
}
