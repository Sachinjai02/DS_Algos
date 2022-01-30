package BitManipulations;

/*
Problem Description
We define f(X, Y) as number of different corresponding bits in binary representation of X and Y.
For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively.
The first and the third bit differ, so f(2, 7) = 2.
You are given an array of N positive integers, A1, A2 ,..., AN.
Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 10^9+7.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 231 - 1
 */
public class DifferentBitsSumPairwise {
    public int cntBits(int[] A) {
        /* To find total differences in the bits of each pair in the array
        apply contribution technique for each bit i.e. from 0th bit to 30th bit
        see how many pairs (with different bits) contribute and sum them up.
        e.g calculate number of set bits at ith pos and then calculate number of pairs of set and unset
        x * (A.length -1) * 2 <--- Note multiplier 2 is needed because in question its mentioned all PAIRS i.e.
        consider P(i,j) and P(j,i) as different
        */
        /* A variation of this question is to find sum of XOR of all the pairs of array elements in which case
           we will just need to multiply 2^i to be contribution to the sum
        */
        int totalSum = 0;
        int mod = 1000000007;
        for(int i=0;i<31;i++) {
            int totalSetBits = 0;
            for(int j=0;j<A.length;j++) {
                if((A[j] & (1<<i)) != 0) {
                    totalSetBits++;
                }
            }
            int pairs = (int) (((long) (totalSetBits) * (A.length - totalSetBits))%mod);
            totalSum = (int) (((long) totalSum + pairs )%mod);
        }
        return (int) ((2  * (long) totalSum)%mod);

    }
}
