package Hashing;

import java.util.HashSet;

/*
Problem Description
For Given Number A find if its COLORFUL number or not.
If number A is a COLORFUL number return 1 else return 0.

What is a COLORFUL Number:
A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.

Problem Constraints
1 <= A <= 2 * 10^9

Input Format
Single Argument which denotes integer A.

Output Format
Return 1 if integer A is COLORFUL else return 0.
 */
public class ColorfulNumber {

    public int colorful_fullSubArrayIterations(int A) {
        HashSet<Long> multiplications = new HashSet();
        String str = A + "";
        //subarray of length
        for(int i=1;i<=str.length();i++) {
            //start index of subarray of length i
            for(int j=0;j<str.length()-i+1;j++) {
                Long mult = 1l;
                for(int k=j;k<j+i;k++) {
                    mult = mult * (str.charAt(k) - '0');
                }
                if(multiplications.contains(mult)) return 0;
                multiplications.add(mult);
            }
        }
        return 1;
    }

    public int colorful(int A) {
        HashSet<Long> multiplications = new HashSet();
        String str = A + "";
        //start indx
        for(int i=0;i<str.length();i++) {
            Long mult = 1l;
            //till end index, continuously carry forward product
            for(int j=i;j<str.length();j++) {
                mult = mult * (str.charAt(j) - '0');
                if(multiplications.contains(mult)) return 0;
                multiplications.add(mult);
            }
        }
        return 1;
    }
}
