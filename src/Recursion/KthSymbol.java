package Recursion;

/*
Problem Description:
On the first row, we write a 0. Now in every subsequent row,
we look at the previous row and replace each occurrence of 0 with 01,
and each occurrence of 1 with 10.
Given row A and index B, return the Bth indexed symbol in row A.
(The values of B are 1-indexed.) (1 indexed).

Problem Constraints
1 <= A <= 20
1 <= B <= 2^A - 1

Input Format
First argument is an integer A.
Second argument is an integer B.

Output Format
Return an integer denoting the Bth indexed symbol in row A.
 */
public class KthSymbol {
    public int solve(int A, int B) {
        if(B==1) return 0;
        int value = solve(A, (B+1)/2);
        if((B & 1) == 0) {
            return value ^ 1; //invert the value
        } else {
            return value;
        }
    }

    //Non-recursive code
    //find number of set bits in the number B; if odd then
    //Set Bit means current number is odd and this would mean in recursive code it would have
    //inverted
    public int solve2(int A, int B) {
        int countSetBits = 0;
        B--; // decreasing it to get 0 based indexing
        while(B > 0) {
            if((B&1) == 1) countSetBits++;
            B = B >> 1;
        }

        return countSetBits%2==0 ? 0 : 1;
    }
}
