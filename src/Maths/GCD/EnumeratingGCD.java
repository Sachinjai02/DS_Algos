package Maths.GCD;

/*
Problem Description:
You are given a number A and a number B. Greatest Common Divisor (GCD) of all numbers between A and B inclusive
is taken (GCD(A, A+1, A+2 … B)).
As this problem looks a bit easy, it is given that numbers A and B can be in the range of 10^100.
You have to return the value of GCD found.
Greatest common divisor of 2 numbers A and B is the largest number D that divides both A and B perfectly.

Problem Constraints
1 <= A <= B <= 10^100

Input Format
First argument is a string denoting A.
Second argument is a string denoting B.

Output Format
Return a string which contains the digits of the integer which represents the GCD.
The returned string should not have any leading zeroes.

Example Input
A = "1"
B = "3"
Example Output
1
 */
public class EnumeratingGCD {
    public String solve(String A, String B) {
        //GCD of two consecutive numbers is always 1 and GCD of 2 same numbers is the number itself
        return A.equals(B) ? A : "1";
    }
}
