package Maths.Combinatorics;

import java.util.Arrays;

public class SortedPermutationRank {

    public int findRank(String A) {
        int rank = 1;
        int p = 1000003;
        for(int i=0;i<A.length()-1;i++) {
            char[] strArr = convertToCharArray(A, i);
            Arrays.sort(strArr);
            int position = 0;
            while(strArr[position] != A.charAt(i)) {
                position++;
            }
            rank = (int) ((rank + ((long) position* factorial(A.length() - 1 - i, p))%p)%p);
        }
        return rank;
    }

    private char[] convertToCharArray(String str, int start) {
        char[] arr = new char[str.length() - start];
        for(int i=0;i<arr.length;i++) {
            arr[i] = str.charAt(start+i);
        }
        return arr;
    }

    private int factorial(int n, int p) {
        int fact = 1;
        for(int i = 2;i<=n;i++) {
            fact = (int) (((long)fact*i)%p);
        }
        return fact;
    }
}
