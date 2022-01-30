package BitManipulations;

/*
Write a function that takes an integer and returns the number of 1 bits it has.

Problem Constraints
1 <= A <= 109

Input Format: First and only argument contains integer A

 */
public class NumberOfSetBits {
    //TC: Log A
    public int numSetBits(int A) {
        int count = 0;
        while(A > 0) {
            if( (A & 1) == 1) {
                count++;
            }
            A = A >> 1;
        }
        return count;
    }
}
