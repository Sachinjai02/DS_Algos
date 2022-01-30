package BitManipulations;
/*
Problem Description
Given a positive integer A, the task is to count the total number of set bits
in the binary representation of all the numbers from 1 to A.
Return the count modulo 10^9 + 7.

Problem Constraints
1 <= A <= 10^9
 */
public class CountTotalSetBits1ToA {

    //Not a totally optimized approach
    public int solve(int A) {
        int mod = 1000000007;
        int maxSetBit = getMaxSetBit(A);
        int totalSetBits = (int) ((maxSetBit * (1l << maxSetBit-1))%mod);
        //we have now got the total number of set bits for all possible numbers lesser than 1<<maxSetBit

        //now to get set bits traverse from 1<<maxSetBit till A
        for(int num=(1<<maxSetBit);num<=A;num++) {
            int setBits = getSetBits(num);
            totalSetBits = (int) (((long) setBits + totalSetBits)%mod);
        }

        return totalSetBits;
    }

    private int getSetBits(int el) {
        int setBits = 0;
        while(el>0) {
            if((el & 1) == 1) {
                setBits++;
            }
            el = el>>1;
        }
        return setBits;
    }

    private int getMaxSetBit(int el) {
        int countBits = 0;
        while(el > 0) {
            el = el >> 1;
            countBits++;
        }
        return countBits-1;
    }
}
