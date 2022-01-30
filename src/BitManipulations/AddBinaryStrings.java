package BitManipulations;

/*
Problem Description:
Given two binary strings, return their sum (also a binary string).
Example:
a = "100"
b = "11"
Return a + b = "111".
 */
public class AddBinaryStrings {

    // TC : O(Max(A.length(), B.length())
    public String addBinary(String A, String B) {
        StringBuilder sumBuilder = new StringBuilder("");
        int max = Math.max(A.length(), B.length());
        int carry = 0;
        for(int i=0;i<max;i++) {
            int digit1 = i < A.length() ? A.charAt(A.length()-1 -  i) - '0' : 0;
            int digit2 = i < B.length() ? B.charAt(B.length()-1 - i) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            carry = sum/2;
            sumBuilder.append(sum%2);
        }
        if(carry != 0) {
            sumBuilder.append(carry);
        }
        return sumBuilder.reverse().toString();
    }

}
