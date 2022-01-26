package Maths.GCD;

import java.util.HashSet;
import java.util.Set;

/*
Problem Description
Given an array of integers A of size N containing GCD of every possible pair of elements of another array.
Find and return the original numbers which are used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.

Problem Constraints
1 <= N <= 10000
1 <= A[i] <= 109

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
        Set<Integer> answer = new HashSet<>();
        for(int i=0;i<A.length;i++) {
            answer.add(A[i]);
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}
