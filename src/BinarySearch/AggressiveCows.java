package BinarySearch;

import java.util.Arrays;

/*
Problem Description
Farmer John has built a new long barn, with N stalls.
Given an array of integers A of size N where each element of the array represents the location of the stall,
and an integer B which represent the number of cows.
His cows don't like this barn layout and become aggressive towards each other once put into a stall.
To prevent the cows from hurting each other, John wants to assign the cows to the stalls,
such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?

Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 10^9
2 <= B <= N

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the largest minimum distance possible among the cows.
 */
public class AggressiveCows {

    public int solve(int[] A, int B) {
        //sort the stalls coordinates
        Arrays.sort(A);
        int l=A[1]-A[0], h = A[A.length-1]-A[0];

        for(int i=1;i<A.length-1;i++) {
            int diff = A[i+1]-A[i];
            l = Math.min(l, diff);
        }
        int minimumDistance = h;
        while(l<=h) {
            int mid = (l+h)/2;
            if(checkIfCowsCanBePlacedAt(A, B, mid)) {
                minimumDistance=mid;
                l=mid+1;//check if they can be placed further
            }else {
                h=mid-1;
            }
        }
        return minimumDistance;
    }

    private boolean checkIfCowsCanBePlacedAt(int[] stalls, int numCows, int minDis) {
        int countPlacedCows = 1; int lastCowPlacedAt = 0;
        for(int i=1;i<stalls.length;i++) {
            if(stalls[i] - stalls[lastCowPlacedAt] >= minDis) {
                countPlacedCows++;
                lastCowPlacedAt = i;
            }
            if(countPlacedCows == numCows) return true;
        }
        return false;
    }
}
