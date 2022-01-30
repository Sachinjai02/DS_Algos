package BitManipulations;

/*
Problem Description
Divide two integers without using multiplication, division and mod operator.
Return the floor of the result of the division.
Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.
NOTE: INT_MAX = 2^31 - 1

Problem Constraints
-2^31 <= A, B <= 2^31-1
B!= 0
Input Format:
First argument is an integer A denoting the dividend.
Second argument is an integer B denoting the divisor.

Output Format: Return an integer denoting the floor value of the division.
 */
public class DivideIntegers {

    public int divide(int A, int B) {
        long absA = A < 0 ? -1 * A : A;
        long absB = B < 0 ? -1 * B : B;
        long count = 0;
        while(absA > 0) {
            absA -= absB;
            count++;
        }
        if((A < 0 && B > 0 ) ||
                (B < 0 && A > 0)) {
            return (int)(-1*count);
        } else {
            return (int) count;
        }
    }
}
