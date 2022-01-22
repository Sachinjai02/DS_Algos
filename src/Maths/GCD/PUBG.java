package Maths.GCD;
/*Problem Description
There are N players each with strength A[i]. when player i attack player j, player j strength reduces
to max(0, A[j]-A[i]). When a player's strength reaches zero, it loses the game and the game continues
in the same manner among other players until only 1 survivor remains.
Can you tell the minimum health last surviving person can have?

Problem Constraints
1 <= N <= 100000
1 <= A[i] <= 1000000

Input Format
First and only argument of input contains a single integer array A.

Output Format
Return a single integer denoting minimum health of last person.

Example Input
Input 1:
A = [6, 4]
Input 2:
A = [2, 3, 4]

Example Output
Output 1: 2
Output 2: 1
*/
public class PUBG {
    public int solve(int[] A) {
        int gcd = A[0];
        for(int i=1;i<A.length;i++) {
            gcd = gcd(gcd, A[i]);
        }
        return gcd;
    }

    private int gcd(int a , int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
