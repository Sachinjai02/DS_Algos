package Maths.Combinatorics;

import java.util.HashMap;
import java.util.Map;

public class SortedPermutationsRankWithDuplicates {
    public static void main(String[] args) {
        new SortedPermutationsRankWithDuplicates().findRank("baa");
    }
    public int findRank(String A) {
        int rank = 1;
        int p = 1000003;
        Map<Character, Integer> charFreq = new HashMap<>();
        for(int i=0;i<A.length();i++) {
            char ch = A.charAt(i);
            Integer count = charFreq.get(ch);
            if(count == null) count = 0;
            charFreq.put(ch, count+1);
        }

        for(int i=0;i<A.length();i++) {
            char ch = A.charAt(i);
            int positionInSortedArrangement = getPosition(ch, charFreq);
            removeElement(charFreq, ch);
            int permutationsBeforePositionSorted = getSpecialPermutations(ch, charFreq, p);
            rank = (int) ((rank + ((long) positionInSortedArrangement * permutationsBeforePositionSorted)%p)%p);
        }

        return rank;

    }

    private int getSpecialPermutations(char ch, Map<Character, Integer> charFreq, int mod) {
        int requiredPerm = (int) (((long) factorialMod(charFreq.size(), mod) *
                inverseMod(getRepetiveProduct(charFreq, mod), mod)) % mod);
        return requiredPerm;
    }

    private int factorialMod(int n, int mod) {
        int fact = 1;
        for(int i=2; i<=n;i++) {
            fact = (int) (((long) fact * i)% mod);
        }
        return fact;
    }

    private int getRepetiveProduct(Map<Character, Integer> charFreq, int mod) {
        int prod = 1;
        for(Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
            if(entry.getValue() > 1) {
                prod = (int) (((long)prod * entry.getValue())%mod);
            }
        }
        return prod;
    }

    private int inverseMod(int num, int mod) {
        return fastPow(num, mod-2, mod);
    }

    public int fastPow(int A, int B, int C) {
        if(A==0) return 0;
        if(B==0) return 1;
        int halfpower = fastPow(A, B/2, C);
        int power = (int) ((halfpower * 1l * halfpower)%C);
        //odd
        if( (B & 1) != 0) {
            int aModC = A < 0 ? A%C + C : A%C ;
            power = (int) ((power * 1l * aModC)%C);
        }
        return power;
    }

    private void removeElement(Map<Character, Integer> charFreq, char ch) {
        Integer freq = charFreq.get(ch);
        if(freq <= 1) {
            charFreq.remove(ch);
        } else {
            charFreq.put(ch, freq-1);
        }
    }

    private int getPosition(char ch, Map<Character, Integer> charFreq) {
        int position = 0;
        for(Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
            if(entry.getKey() < ch) {
                position = position + entry.getValue();
            }
        }
        return Math.max(position, 0);
    }
}
