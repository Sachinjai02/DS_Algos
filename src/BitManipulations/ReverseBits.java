package BitManipulations;

/*
Problem Description
Reverse the bits of an 32 bit unsigned integer A.

Problem Constraints
0 <= A <= 2^32
 */
public class ReverseBits {
    public long reverse(long a) {
        long reverse = 0;
        for(int i=0;i<32;i++) {
            if((a & (1<<i)) != 0) {
                reverse |= (1l << (31-i)); // not the long in 1l
            }
        }
        return reverse;
    }
}
