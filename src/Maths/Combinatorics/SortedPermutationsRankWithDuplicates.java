package Maths.Combinatorics;

import java.util.HashMap;
import java.util.Map;

public class SortedPermutationsRankWithDuplicates {
    public static void main(String[] args) {
        String s  = "settle";
        int rank = new SortedPermutationsRankWithDuplicates().findRank(s);
        System.out.println("rank of " + s + " is " + rank);
    }
    /* Rank is to be calculated based on
    1+ V(i=0 to length-1) Sum(  no. of chars lower than ith char on its right side *
                                fact(number of slots left on i's right) /
                                fact(rep1)* fact(rep2) ... for all chars to right of i including  ith char);
   */
    class Pair {
        int rank;
        int count;

    }

    public int findRank(String A) {
        int mod = 1000003;
        Map<Character, Pair> pairRanks = new HashMap();
        //create a map of ranks
        for(int i=0;i<A.length();++i) {
            char ch = A.charAt(i);
            Pair p = pairRanks.get(ch);
            if(p==null) {
                p = new Pair();
                pairRanks.put(ch, p);
            }
            ++(p.count);
        }
        //find ranks
        for(Map.Entry<Character, Pair> entry : pairRanks.entrySet()) {
            int rank = 0;
            Pair currentPair = entry.getValue();
            for(Map.Entry<Character, Pair> entry2 : pairRanks.entrySet()) {
                if(entry2.getKey() < entry.getKey()) {
                    ++rank;
                }
            }
            currentPair.rank=rank;
        }

        int[] facts = new int[A.length()+1];
        facts[0] = 1; facts[1] = 1;

        //calculate factorial mod array of  A.length()
        for(int i=2;i<=A.length();++i) {
            facts[i] = (int) (((long) i*facts[i-1])%mod);
        }
        int finalRank = 1;

        //Loop through A
        for(int i=0;i<A.length();++i) {
            char element = A.charAt(i);
            int numCharsBeforeElement = getTotalCharsBefore(pairRanks, element);
            if( numCharsBeforeElement > 0) {
                int currentArrangements = (int) (((long) numCharsBeforeElement * facts[A.length()-1-i])%mod);
                for(Map.Entry<Character, Pair> entry : pairRanks.entrySet()) {
                    Pair currentPair = entry.getValue();
                    if(currentPair.count > 1) {
                        currentArrangements = (int) (((long)currentArrangements * pow(facts[currentPair.count], mod-2, mod))%mod);
                    }
                }
                finalRank = (finalRank + currentArrangements)%mod;
            }
            removeElement(pairRanks, element);
        }
        return finalRank;
    }

    private int getTotalCharsBefore(Map<Character, Pair> pairRanks, char element) {
        int totalChars = 0;
        int rankElement = pairRanks.get(element).rank;
        for(Map.Entry<Character, Pair> entry : pairRanks.entrySet()) {
            Pair currentPair = entry.getValue();
            if(entry.getKey() != element && currentPair.rank < rankElement) {
                totalChars += currentPair.count;
            }
        }
        return totalChars;
    }

    private void removeElement(Map<Character, Pair> pairRanks, char element) {
        int count = pairRanks.get(element).count;
        if(count > 1) {
            --(pairRanks.get(element).count);
            return;
        }
        int rankElement = pairRanks.get(element).rank;

        for(Map.Entry<Character, Pair> entry : pairRanks.entrySet()) {
            Pair currentPair = entry.getValue();
            if(currentPair.rank > rankElement) {
                --(currentPair.rank);
            }
        }
        pairRanks.remove(element);
    }

    int pow(int n, int p, int m) {
        if(p==0) return 1;
        int half = pow(n,p/2,m);
        int full = (int)((half * 1l * half ) % m);
        return ( (p&1)==0) ? full : (int) ((full * 1l * n)%m);
    }
}
