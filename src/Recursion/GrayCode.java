package Recursion;

import java.util.ArrayList;

/*
Problem Description
The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer A representing the total number of bits in the code,
print the sequence of gray code.
A gray code sequence must begin with 0.

Problem Constraints
1 <= A <= 16

Input Format
First argument is an integer A.

Output Format
Return an array of integers representing the gray code sequence.

Example Input
Input 1:A = 2
Input 2:A = 1
Example Output
output 1:[0, 1, 3, 2]
output 2:[0, 1]
 */
public class GrayCode {
    //000
    //001
    //011
    //010
    //110
    //111
    //101
    //100
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> grayCodeList = new ArrayList();
        grayCode(grayCodeList, a);
        return grayCodeList;
    }

    private void grayCode(ArrayList<Integer> gc, int n) {
        if(n==1) {
            gc.add(0);
            gc.add(1);
            return;
        }
        grayCode(gc, n-1);
        int size = gc.size();
        for(int i=size-1;i>=0;i--) {
            gc.add(gc.get(i) + (1<<(n-1)));
        }
    }
}
