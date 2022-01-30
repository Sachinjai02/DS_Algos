package BitManipulations;
/*
Problem Description
Given an array of numbers A , in which exactly two elements appear only once and
all the other elements appear exactly twice. Find the two elements that appear only once.

Note: Output array must be sorted.

Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109
 */
public class AllRepeatingTwiceExceptTwo {

    public int[] solve(int[] A) {
        int xorAll = A[0];
        for(int i=1;i<A.length;i++) {
            xorAll ^= A[i];
        }

        int setBitPos = 0;
        for(int i=0; i<31;i++) {
            if((xorAll & (1<<i)) != 0) {
                setBitPos = i;
                break;
            }
        }

        //split the array and keep on doing xor on set and unsets
        int setXor = 0, unsetXor = 0;
        for(int i=0;i<A.length;i++) {
            if( (A[i] & (1<<setBitPos)) != 0) {
                setXor ^= A[i];
            } else {
                unsetXor ^= A[i];
            }
        }

        return new int[] { Math.min(setXor, unsetXor), Math.max(setXor, unsetXor)};
    }
}
