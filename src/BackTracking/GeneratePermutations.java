package BackTracking;

import java.util.Arrays;

public class GeneratePermutations {
    private static int counter = 0;
    public static void main(String[] args) {
        new GeneratePermutations().solve(new int[] { 1 , 2  ,3, 4});
    }
    public void solve(int[] A) {
        Arrays.sort(A);
        generatePermutations(A, 0);
    }

    private void generatePermutations(int[] A, int pos) {
        if(pos == A.length-1) {
            printArr(A);
        }
        for(int i=pos;i<A.length;++i) {

            swap(A, pos, i);
            generatePermutations(A, pos+1);
            swap(A, pos, i);
        }
    }

    private void printArr(int[] a) {
        System.out.print(++counter + ". ::: ");
        for(int i=0;i<a.length;++i) {
            System.out.print( a[i] + " ");
        }
        System.out.println();
    }

    private void swap(int[] A, int i, int j) {
        if(i != j) {
            A[i] = A[i] ^ A[j];
            A[j] = A[i] ^ A[j];
            A[i] = A[i] ^ A[j];
        }
    }


}
