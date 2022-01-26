package Maths.ModularArithmetics;

import java.util.ArrayList;

/*
Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
Example:
Input : [1, 0]
Return : [0, 1]
Lets say N = size of the array. Then, following holds true :

All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer
*/
public class RearrangeArray {

    public void arrange(ArrayList<Integer> A) {
        /*We would require to hold both current value inside A[i] as well as A[A[i]]
        Let's replace the array elements by A[i]*N + A[A[i]]
           OR
        A[A[i]] * N + A[i]
        */
        int N = A.size();
        for(int i=0;i<N;i++) {
            A.set(i, A.get(i) * N);
        }

        for(int i=0;i<N;i++) {
            int AiIdx = A.get(i)/N;
            int elementToAdd = A.get(AiIdx)/N;
            A.set(i, A.get(i)+elementToAdd);
        }

        for(int i=0;i<N;i++) {
            A.set(i, A.get(i)%N);
        }
    }
}
