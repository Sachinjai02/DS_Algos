package Hashing;

import java.util.HashMap;
import java.util.Map;

/*
Problem Description
Given an array A of N integers.
Find the largest continuous sequence in a array which sums to zero.

Problem Constraints
1 <= N <= 10^6
-10^7 <= A[i] <= 10^7

Input Format
Single argument which is an integer array A.

Output Format
Return an array denoting the longest continuous sequence with total sum of zero.
NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
If there is no such sequence then return empty array
 */
public class LargestContinuousSequenceZeroSum {
    public int[] lszero(int[] A) {
        Map<Long, Integer> pfSumFirstOccurrenceIdx = new HashMap();
        Long[] pfSum = new Long[A.length];
        Long carryForward = 0l;
        pfSumFirstOccurrenceIdx.put(0l,-1);
        for(int i=0;i<A.length;i++) {
            carryForward += A[i];
            pfSum[i] = carryForward;
            if(! pfSumFirstOccurrenceIdx.containsKey(carryForward)) {
                pfSumFirstOccurrenceIdx.put(carryForward, i);
            }
        }
        int largestSeqLength = 0, startIdx = -1;
        for(int i=0;i<pfSum.length;i++) {
            int firstOcc = pfSumFirstOccurrenceIdx.get(pfSum[i]);
            if(i != firstOcc) {
                int lengthOfZeroSubArraySum = i-firstOcc;
                if(lengthOfZeroSubArraySum > largestSeqLength) {
                    largestSeqLength = lengthOfZeroSubArraySum;
                    startIdx = firstOcc+1;
                }
            }
        }

        int[] largestSubArr = new int[largestSeqLength];
        for(int i=0;i<largestSubArr.length;i++) {
            largestSubArr[i] = A[startIdx+i];
        }
        return largestSubArr;
    }
}
