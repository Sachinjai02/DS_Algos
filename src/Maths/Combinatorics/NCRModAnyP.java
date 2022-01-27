package Maths.Combinatorics;

/*
Problem Description
Given three integers A, B and C, where A represents n,
B represents r and C represents m, find and return the value of
nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

Problem Constraints
1 <= A * B <= 10^6
1 <= B <= A
1 <= C <= 10^6
 */
public class NCRModAnyP {

    //Pascal's triangle
    public int solve(int A, int B, int C) {
        //NCr = N C (N-r)
        if(B > A-B) {
            B = A-B;
        }
        if(C==1) return 0;
        int[] ncrArr = new int[B+1];
        ncrArr[0] = 1;
        for(int i=1;i<=A;i++) {
            for(int col = B; col >=1;col--) {
                ncrArr[col] = (int) (((long)ncrArr[col] + ncrArr[col-1]) % C);
            }
        }
        return ncrArr[B];
    }
}
