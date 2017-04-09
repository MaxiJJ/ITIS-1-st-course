package febrary28;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Максим on 28.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = 3;
        String[] arr = new String[length];

        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextLine();
        }

        Arrays.parallelSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}