package Sorting;

import java.util.ArrayList;
import java.util.List;

public class Sorting {

    public void sort(int[] A) {
        /* Try implementing quick, merge, radix, insertion, selection, bubble */
        // quickSort(A);
        // mergeSort(A);
        // insertionSort(A);
        // selectionSort(A);
        // bubbleSort(A);
        // radixSort(A);
    }

    public void radixSort(int[] A) {
        List<Integer>[] lists = new ArrayList[10];
        int maxDigit = getMaxDigit(A);
        for(int i=0;i<lists.length;++i) {
            lists[i] = new ArrayList();
        }

        for(int i=0;i<maxDigit;++i) {
            for(int j=0;j<A.length;++j) {
                int kthDigit = (A[j]% (int) Math.pow(10,i+1))/(int) Math.pow(10,i);
                lists[kthDigit].add(A[j]);
            }
            int k=0;
            for(int j=0;j<10;++j) {
                for(int num : lists[j]) {
                    A[k++] = num;
                }
                lists[j].clear();
            }
        }
    }

    private int getMaxDigit(int[] A) {
        int maxNum = A[0];
        for(int i=1;i<A.length;++i) {
            maxNum = Math.max(A[i], maxNum);
        }
        int maxDigit = 1;
        while(maxNum > 9) {
            maxNum = maxNum/10;
            ++maxDigit;
        }
        return maxDigit;
    }

    public void bubbleSort(int[] A) {
        int countSwaps = 0;
        for(int i=0;i<A.length-1;++i) {
            countSwaps = 0;
            for(int j=0;j<A.length-1-i;++j) {
                if(A[j] > A[j+1]) {
                    swap(A, j, j+1);
                    ++countSwaps;
                }
            }
            if(countSwaps == 0) break;
        }
    }


    public void selectionSort(int[] A) {
        int min = 0, minIdx = -1;
        for(int i=0;i<A.length-1;++i) {
            min = A[i]; minIdx = i;
            for(int j=i+1;j<A.length;++j) {
                if(min > A[j]) {
                    min = A[j];
                    minIdx = j;
                }
            }
            swap(A, i, minIdx);
        }
    }

    public void insertionSort(int[] A) {
        int j=0;
        for(int i=1;i<A.length;++i) {
            j = i;
            while(j>0 && A[j] < A[j-1]) {
                swap(A, j, j-1);
                --j;
            }
        }
    }



    public void mergeSort(int[] A) {
        mergeSort(A, 0, A.length-1);
    }

    private void mergeSort(int[] A, int s, int e) {
        if(s==e) return;
        int m = (s+e)/2;
        mergeSort(A, s, m);
        mergeSort(A, m+1, e);
        combine(A, s, e);
    }

    private void combine(int[] A, int s, int e) {
        int m = (s+e)/2;
        int p1 = s, p2 = m+1, p=0;
        int[] merged = new int[e-s+1];
        while(p1 <= m && p2 <= e) {
            if(A[p1] > A[p2]) {
                merged[p++] = A[p2++];
            } else {
                merged[p++] = A[p1++];
            }
        }

        while(p1 <= m) {
            merged[p++] = A[p1++];
        }

        while(p2 <= e) {
            merged[p++] = A[p2++];
        }

        for(int i=s;i<=e;++i) {
            A[i] = merged[i-s];
        }

    }

    public void quickSort(int[] A) {
        quickSort(A,0, A.length-1);
    }

    private void quickSort(int[] A, int s, int e) {
        if(s >= e) return;
        int partition = partition(A, s, e);
        quickSort(A, s, partition-1);
        quickSort(A, partition+1, e);
    }

    private int partition(int[] A, int s, int e) {
        int p1 = s+1, p2 = e;
        while(p1 <= p2) {
            if(A[p1] <= A[s]) {
                ++p1;
            } else if(A[p2] > A[s]) {
                --p2;
            } else {
                swap(A, p1, p2);
                ++p1;
                --p2;
            }
        }
        swap(A, p1-1, s);
        return p1-1;
    }

    private void swap(int[] A, int i, int j) {
        if(i != j) {
            A[i] = A[i] ^ A[j];
            A[j] = A[i] ^ A[j];
            A[i] = A[i] ^ A[j];
        }
    }

}
