package Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
Problem Description
Given a string A consisting of lowercase characters.
Check if characters of the given string can be rearranged to form a palindrome.
Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.

Problem Constraints
1 <= |A| <= 10^5
A consists only of lower-case characters.

Input Format
First argument is an string A.

Output Format
Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
 */
public class CanFormPalindrome {
    public int solve(String A) {
        Map<Character, Integer> characterOccurrences = new HashMap();
        for(int i=0;i<A.length();i++) {
            char ch = A.charAt(i);
            Integer numOcc = characterOccurrences.getOrDefault(ch,0);
            characterOccurrences.put(ch, numOcc+1);
        }

        int numberCharactersOdd = 0;
        Set<Map.Entry<Character, Integer>> entrySet = characterOccurrences.entrySet();
        for(Map.Entry<Character, Integer> entry: entrySet) {
            if((entry.getValue() & 1) == 1) {
                numberCharactersOdd++;
            }
        }

        return (numberCharactersOdd <= 1) ? 1 : 0;
    }
}
