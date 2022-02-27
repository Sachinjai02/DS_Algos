package BinarySearch;

/*
Given the price list at which tickets for a flight were purchased, figure out the kth smallest price for the flight.
kth smallest price is the minimum possible n such that there are at least k price elements in the price list with value <= n.
In other words, if the price list was sorted, then A[k-1] ( k is 1 based, while the array is 0 based ).

NOTE You are not allowed to modify the price list ( The price list is read only ). Try to do it using constant extra space.

Example:
A : [2 1 4 3 2]
k : 3
Answer : 2

Constraints :
1 <= number of elements in the price list <= 1000000
1 <= k <= number of elements in the price list
 */
public class KthSmallestElement {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        int min = A[0], max = A[0], kthSmallest = 0;
        for(int i=1;i<A.length;i++) {
            if(A[i] < min) {
                min = A[i];
            }
            if(A[i] > max) {
                max = A[i];
            }
        }

        while(min <= max) {
            int mid = (min+max)/2;
            //assume that mid is the required answer and see if there are B elements lesser than equal to mid
            int count = getElementsSmallerEqualTo(A, mid);
            if(count >= B) {
                kthSmallest = mid;
                max = mid-1;
            } else {
                min = mid+1;
            }
        }
        return kthSmallest;
    }

    private int getElementsSmallerEqualTo(int[] A, int el) {
        int count =0;
        for(int i=0;i<A.length;i++) {
            if(A[i] <= el) {
                count++;
            }
        }
        return count;
    }
}
