package BitManipulations;

/*
Problem Description
Given an integer A.
Two numbers X and Y are defined as follows:

X is the greatest number smaller than A such that XOR sum of X and A is the same as the sum of X and A.
Y is the smallest number greater than A such that XOR sum of Y and A is the same as the sum of Y and A.
Find and return the XOR of X and Y.

NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.
NOTE 2: Your code will be run against a maximum of 100000 Test Cases.

Problem Constraints
1 <= A <= 10^9
 */
public class StrangeEquality {
    /*
    If two numbers have to have same XOR and SUM that means they will have to have opposite bits at same position
    Or they should have bits unset at that position

    -> Now the smallest number greater than A would have to be 2 * A i.e. all bits 0 in new number
    and (largest set bit position in original number + 1 )set in the new number.
    -> For the largest number smaller than B, we should get all unset bits in original number to set

     */
    public int solve(int A) {
        int leastSetBitPos = -1;
        int largestSetBit = countBits(A) - 1;
        int sum = (1<<(largestSetBit+1));

        for(int i=largestSetBit-1;i>=0;i--) {
            if( (A & (1 << i)) == 0) {
                sum += (1<<i);
            }
        }
        return sum;
    }

    private int countBits(int A) {
        int countBits = 0;
        while(A>0) {
            countBits++;
            A=A>>1;
        }
        return countBits;
    }
}
