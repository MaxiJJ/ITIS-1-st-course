import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {
        int[] a = generateArray();
        System.out.println(Arrays.toString(a));
    }

    static int[] generateArray() {
        int arrLength = 5;
        int[] arr = new int[arrLength];
        arr[0] = (int) (1 + Math.random() * 3);
        for (int i = 1; i < arrLength; i++) {
            arr[i] = arr[i - 1] * arr[i - 1];
        }

        return arr;
    }
}
