package Arrays;

import java.util.Arrays;
/*
Quite often we are given methods to implement a function where inputs/outputs are tied to primitive array
 */
public class ConvertBoxedArrayToPrimitive {
    private static void main(String[] s) {
        Integer[] wrapperInts = new Integer[] { 1, 2, 3, 4};
        int[] primitiveInts = Arrays.stream(wrapperInts).mapToInt(i -> i).toArray();
    }
}