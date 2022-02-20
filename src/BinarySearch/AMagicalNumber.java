package BinarySearch;

/*
Problem Description:
Given three positive integers A, B and C.
Any positive integer is magical if it is divisible by either B or C.
Return the Ath magical number. Since the answer may be very large, return it modulo 109 + 7.

Problem Constraints
1 <= A <= 109
2 <= B, C <= 40000

Input Format:
The first argument given is an integer A.
The second argument given is an integer B.
The third argument given is an integer C.

Output Format: Return the Ath magical number. Since the answer may be very large, return it modulo 109 + 7.
 */
public class AMagicalNumber {
    public int solve(int A, int B, int C) {
        int max = Math.max(B,C);
        int min = Math.min(B,C);
        int mod = 1000000007;
        if( (max % min) == 0) {
            return (int) (((long) A * min)%mod);
        }
        long lcm = (long) B*C/gcd(B,C);
        long l=min, h=(long)max*(A/2+1), ans = 0;
        while(l<=h) {
            long mid = (l+h)/2;
            long multiples = mid/B + mid/C - mid/lcm;
            if(multiples == A) {
                ans = mid;
                h = mid-1;
            } else if(multiples > A) {
                h = mid-1;
            } else {
                l=mid+1;
            }
        }

        return (int) (ans%mod);

    }

    private int gcd(int a, int b) {
        if(b==0) {
            return a;
        }
        return gcd(b, a%b);
    }
}
