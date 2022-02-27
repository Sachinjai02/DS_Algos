package Hashing;

import java.util.HashMap;
import java.util.Map;

/*
Problem Description
You are given an array of N integers, A1, A2 ,…, AN and an integer B.
Return the of count of distinct numbers in all windows of size B.
Formally, return an array of size N-B+1 where i'th element
in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.

Input Format
First argument is an integer array A
Second argument is an integer B.

Output Format
Return an integer array
 */
public class DistinctNumbersInWindow {

    public int[] dNums(int[] A, int B) {
        if(B>A.length) return new int[0];

        int[] distinctElements = new int[A.length-B+1];
        Map<Integer, Integer> uniqueElFreq = new HashMap();
        for(int i=0;i<B;i++) {
            addElementWithFreqToMap(uniqueElFreq, A[i]);
        }

        distinctElements[0] = uniqueElFreq.size();
        for(int i=1;i<A.length-B+1;i++) {
            addElementWithFreqToMap(uniqueElFreq, A[i+B-1]);
            removeElementFromFreqMap(uniqueElFreq, A[i-1]);
            distinctElements[i] = uniqueElFreq.size();
        }

        return distinctElements;
    }

    private void removeElementFromFreqMap(Map<Integer, Integer> elementFreq, int el) {
        Integer freq = elementFreq.get(el);
        if(freq == 1) {
            elementFreq.remove(el);
        } else {
            elementFreq.put(el, freq-1);
        }

    }

    private void addElementWithFreqToMap(Map<Integer, Integer> elementFreq, int el) {
        Integer freq = elementFreq.get(el);
        if(freq == null) {
            freq = 0;
        }
        elementFreq.put(el, freq+1);
    }
}
