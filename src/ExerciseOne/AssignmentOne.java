package ExerciseOne;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class AssignmentOne {

    public AssignmentOne() {

        int[] arr = new int[10];
        Arrays.setAll(arr, operand -> ++operand);

        System.out.println("Exercise 1");
        System.out.println(Arrays.toString(arr));

        insertElement(arr, 10, 2);

        System.out.println(Arrays.toString(arr));

        System.out.println("---------------------");

    }

    private void insertElement(int[] arr, int el, int index) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = el;
    }

    public static void main(String[] args) {
        new AssignmentOne();
    }
}
