package BitManipulations;

/*
Problem Description
You have an array A with N elements. We have 2 types of operation available on this array :
We can split a element B into 2 elements C and D such that B = C + D.
We can merge 2 elements P and Q as one element R such that R = P^Q i.e XOR of P and Q.
You have to determine whether it is possible to make array A containing only 1 element
i.e. 0 after several splits and/or merge?

Problem Constraints
1 <= N <= 100000
1 <= A[i] <= 106
 */
public class SplitAndMerge {
    //Every even number can be divided into 2 and therefore merged to 0
    //Every odd number can only be merged to 0 if their 0th bits are in pair
    // So really its about checking if number of set 0 bits are even or odd
    public String solve(int[] A) {
        int numSetBits = 0;
        for(int j=0;j<A.length;j++) {
            if((A[j] & 1) != 0) {
                numSetBits++;
            }
        }
        if( (numSetBits & 1) == 0) {
            return "Yes";
        }
        return "No";
    }
}
