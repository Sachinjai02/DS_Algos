package Maths.GCD;

/**
 Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor)
 of the remaining array is maximum. Find the maximum value of GCD.

  Problem Constraints::
  2 <= N <= 105
  1 <= A[i] <= 109

  Input Format
  First argument is an integer array A.

  Output Format
  Return an integer denoting the maximum value of GCD.

  Example Input
  Input 1:
  A = [12, 15, 18]
  Input 2:
  A = [5, 15, 30]
  Example Output
  Output 1 : 6
  Output 2: 15
 */
public class DeleteOne {

    public int solve(int[] A) {
        //Build a suffix GCD Array
        int[] suffixGCD = new int[A.length];
        suffixGCD[A.length-1] = A[A.length-1];
        for(int i=A.length-2;i>=0;i--) {
            suffixGCD[i] = gcd(A[i], suffixGCD[i+1]);
        }
        int currentForwardGcd = A[0];
        int maxGcd = suffixGCD[1];
        for(int i=1;i<A.length-1;i++) {
            int leftGcd = currentForwardGcd;
            int rightGcd = suffixGCD[i+1];
            maxGcd = Math.max(maxGcd, gcd(leftGcd, rightGcd));
            currentForwardGcd = gcd(currentForwardGcd, A[i]);
        }

        maxGcd = Math.max(maxGcd, currentForwardGcd);
        return maxGcd;

    }

    private int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
