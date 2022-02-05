package Arrays;

import java.util.Arrays;

public class ArrangeNegativePositive {
    public static void main(String[] args) {
        //int arr[] = new int[] {2,3,4,5,-3,-9,-8,-5};
        int arr[] = new int[] { -5, 3, -9, 5, -3, 4, -8, 2 , 8, 8, -9 , -9 , -7};
        new ArrangeNegativePositive().arrange(arr);
        Arrays.stream(arr).forEach(a-> System.out.print(a + ", "));
    }

    private void arrange(int[] arr) {
        //[2,3,4,5,-3,-9,-8,-5] -> [-3,2,-9,3,-8,4,-5,5]
        int start = 0, end = arr.length-1;
        int countP = 0,  countN = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] >=0) {
                countP++;
            }
        }
        countN = arr.length - countP;
        //odd indexes +ve and even indexes -ve
        while(start < arr.length && end >= 0) {
            //if odd index has a +ve number and it should remain +ve or if even index has a -ve number and it should have
            //been negative, then don't change
            if( ((end&1) == 1 && arr[end] >= 0 && end <= 2*countP-1)
                    || ((end&1) == 0 && arr[end] < 0 && end <= 2*(countN - 1))
            ) {
                end--;
            }
            else if( ((start&1) == 1 && arr[start] >= 0 && start <= 2*countP-1)
                    || ((start&1) == 0 && arr[start] < 0 && start <= 2*(countN - 1))) {
                start++;
            } else {
                //swap
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }


    }
}
