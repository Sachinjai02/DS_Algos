package Recursion;

import java.util.Scanner;

/*
Write a recursive function that, given a string S,
prints the characters of S in reverse order.

Problem Constraints
1 <= |s| <= 1000
 */
public class PrintReverseString {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        printLast(inputStr, inputStr.length());
    }

    private static void printLast(String str, int length) {
        System.out.print(str.charAt(length - 1));
        if(length == 1) {
            return;
        }
        printLast(str, length-1);
    }
}
