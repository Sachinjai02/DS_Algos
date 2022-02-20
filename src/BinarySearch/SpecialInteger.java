package BinarySearch;

/*
Problem Description
Given an array of integers A and an integer B,
find and return the maximum value K such that there is no subarray in A of size K
with sum of elements greater than B.

Problem Constraints:
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format: The first argument given is the integer array A.
The second argument given is integer B.
Output Format: Return the maximum value of K (sub array length).

Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = 10
Input 2:
A = [5, 17, 100, 11]
B = 130

Example Output
Output 1: 2
Output 2: 3
 */
public class SpecialInteger {

    public int solve(int[] A, int B) {
        //A: 1,2,3,4,7,9
        //idx    0 1 2 3 4 5
        // find max subarray sum of size K such that the max sum <=B
        //search space : 1, A.length
        int l = 1, h = A.length, k=0;
        while(l<=h) {
            int mid = (l+h)/2;
            long maxSum = getMaxSubarraySum(A, mid);
            if(maxSum > B) {
                h=mid-1;
            } else {
                k=mid;
                l=mid+1;
            }
        }
        return k;
    }

    private long getMaxSubarraySum(int[] A, int subArrSize) {
        long sum=0;
        for(int i=0;i<subArrSize;i++) {
            sum += A[i];
        }
        long maxSum = sum;
        for(int i=1;i<=A.length-subArrSize;i++) {
            sum = sum - A[i-1] + A[i+subArrSize-1];
            maxSum=Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
