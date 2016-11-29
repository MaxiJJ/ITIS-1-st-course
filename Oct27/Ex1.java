import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        Integer[] a1 = generateArray();
        Integer[] a2 = generateArray();
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        a1 = reverseArray(a1);
        a2 = reverseArrayCollections(a2);

        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }

    static Integer[] generateArray() {
        int arrLength = 1 + (int) (Math.random() * 10);
        Integer[] arr = new Integer[arrLength];
        for (int i = 0; i < arrLength; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    static Integer[] reverseArray(Integer[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }

    static Integer[] reverseArrayCollections(Integer[] arr) {
        List<Integer> arr2 = Arrays.asList(arr);
        Collections.reverse(arr2);

        return arr2.toArray(new Integer[arr.length]);
    }
}
