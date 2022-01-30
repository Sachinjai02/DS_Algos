package Arrays;

import java.util.Arrays;
/*
Quite often we are given methods to implement a function where inputs/outputs are tied to primitive array
 */
public class ConvertPrimitiveArrayToJava {

    public static void main(String[] s) {
        int[] integerArr = new int[] {1, 3, 3, 4, 4};
        Integer[] objects = Arrays.stream(integerArr).boxed().sorted((a, b) -> {
            return (b - a);
        }).toArray(Integer[]::new);
        System.out.println(objects);
    }
}