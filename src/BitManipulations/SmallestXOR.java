package BitManipulations;

/*
Problem Description
Given two integers A and B, find a number X such that A xor X is minimum possible,
and the number of set bits in X equals B.

Problem Constraints
0 <= A <= 10^9
0 <= B <= 30

Input Format: First argument contains a single integer A. Second argument contains a single integer B.
Output Format: Return a single integer X.

Example Input
Input 1: A = 3 B = 3
Input 2: A = 15 B = 2

Example Output
Output 1:7
Output 2:12
 */
public class SmallestXOR {
    public int solve(int A, int B) {
        int numSetBits = B;
        int minimumPossibleXorelement = 0;
        //To get min possible XOR keep on reducing largest set bits contribution by adding them to the answer
        for(int i=30;i>=0;i--) {
            if(numSetBits == 0) {
                break;
            }
            if((A & (1<<i)) != 0) {
                minimumPossibleXorelement += (1<<i);
                numSetBits--;
            }
        }

        //if there were still some set bits to be included then add them from the least significant bits where original
        //number had the bit unset
        for(int i=0;i<31;i++) {
            if(numSetBits == 0) {
                break;
            }
            if((A & (1<<i)) == 0) {
                minimumPossibleXorelement += (1<<i);
                numSetBits--;
            }
        }
        return minimumPossibleXorelement;
    }
}
