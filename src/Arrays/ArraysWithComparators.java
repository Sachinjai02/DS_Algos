package Arrays;

import java.util.Arrays;

public class ArraysWithComparators {


    public static void main(String[] args) {
        Integer[] myArr = new Integer[] { 10 ,2 ,3 ,6, 89};
        Arrays.sort(myArr, (a, b) -> {
            return a-b; //+ve means a will come later
            //-ve means a will go first
        });
        Arrays.stream(myArr).forEach(a -> System.out.printf(a + " "));
        System.out.println();
        Arrays.sort(myArr, (a, b) -> {
            return b-a; //+ve (i.e. b>a -> decreasing) means a will come later
            //-ve means a will go first
        });
        Arrays.stream(myArr).forEach(a -> System.out.printf(a + " "));
    }

}
