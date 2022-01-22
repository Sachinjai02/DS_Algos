package Maths.GCD;
/*
Problem Description
You are given two positive numbers A and B . You need to find the maximum valued integer X such that:
X divides A i.e. A % X = 0
X and B are co-prime i.e. gcd(X, B) = 1

Problem Constraints
1 <= A, B <= 109

Input Format
First argument is an integer A.
Second argument is an integer B.

Output Format
Return an integer maximum value of X as descibed above.

Example Input
Input 1:
 A = 30
 B = 12
Input 2:
 A = 5
 B = 10
Example Output
Output 1: 5
Output 2: 1
 */
public class LargestCoprimeDivisor {
    /*
   // TC: O(sqrt(A) * Log(A))
    public int cpFact(int A, int B) {
        int maxcpFact = 0;
        for(int i=1;i*i<=A;i++) {
            if(A%i == 0) {
                int factA = i;
                if(checkCoPrime(factA, B)) {
                    maxcpFact = Math.max(maxcpFact, factA);
                }
                factA = A/i;
                if(checkCoPrime(factA, B)) {
                    maxcpFact = Math.max(maxcpFact, factA);
                }
            }
        }

        return maxcpFact;
    }

    private boolean checkCoPrime(int X, int Y) {
        return  gcd(X,Y)==1;
    }
    */

    //TC: LogA
    public int cpFact(int A, int B) {
        //Remove all factors of A and B from A until we find the number which is co-prime with B
        int gcd = gcd(A, B);
        while (gcd != 1) {
            A = A/gcd;
            gcd = gcd(A, B);
        }
        return A;
    }



    private int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}
