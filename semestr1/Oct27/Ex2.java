import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        long[] a = generateArray();
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(changeArray(a)));
    }

    static long[] generateArray() {
        int arrayLength = (int) (3 + Math.random() * 6);
        long[] arr = new long[arrayLength];
        for (int i = 0; i < 2; i++) {
            arr[i] = (long) (Math.random() * 5);
        }
        return arr;
    }

    static long[] changeArray(long[] arr) {
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 2] * arr[i - 1];
        }
        return arr;
    }
}
