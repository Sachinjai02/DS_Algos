package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**

Problem Description
Given an unsorted integer array A of size N.
Find the length of the longest set of consecutive elements from the array A.

Problem Constraints
1 <= N <= 10^6
-10^6 <= A[i] <= 10^6

Input Format
First argument is an integer array A of size N.

 Output Format
Return an integer denoting the length of the longest set of consecutive elements from the array A.

 Example Input
Input 1:
A = [100, 4, 200, 1, 3, 2]
Input 2:
A = [2, 1]

Example Output
Output 1:
 4
Output 2:
 2
 */
public class LongestConsecutiveSeq {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    //tc:O(n); SC: O(N)
    public int longestConsecutive(final int[] A) {
        Set<Integer> set = new HashSet();
        for(int i=0;i<A.length;i++) {
            set.add(A[i]);
        }

        int maxSeqLength = 1;

        for(int i=0;i<A.length;i++) {
            if(set.contains(A[i]-1)) {
                continue;
            }

            int element = A[i];
            int countCons = 1;
            while(set.contains(++element)) {
                countCons++;
            }
            maxSeqLength = Math.max(maxSeqLength, countCons);
        }

        return maxSeqLength;
    }
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    //Recursive approach
    public int longestConsecutive_REC(final int[] A) {
        HashMap<Integer, Integer> elementSequencePair = new HashMap();
        for(int i=0;i<A.length;i++) {
            elementSequencePair.put(A[i], -1);
        }
        int largestSequence = 1;
        for(Map.Entry<Integer,Integer> entry: elementSequencePair.entrySet()) {
            setLongestConsecutiveSequence(entry.getKey(), elementSequencePair);
            int currentConsSeq = elementSequencePair.get(entry.getKey());
            if(currentConsSeq > largestSequence) {
                largestSequence = currentConsSeq;
            }
        }

        return largestSequence;

    }

    private Integer setLongestConsecutiveSequence(Integer element, HashMap<Integer, Integer> elementSequencePair) {
        if(! elementSequencePair.containsKey(element)) {
            return 0;
        }
        if(elementSequencePair.get(element) != -1)  return elementSequencePair.get(element);
        Integer longest =  1 + setLongestConsecutiveSequence(element-1, elementSequencePair);
        elementSequencePair.put(element, longest);
        return longest;
    }
}
