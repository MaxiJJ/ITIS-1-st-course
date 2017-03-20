<<<<<<< HEAD
package febrary28.structure;

import java.util.Arrays;

/**
 * Created by Максим on 21.02.2017.
 */
public class ArrayUtils {
    public static <T> void fill(T[] arr, T obj) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = obj;
        }
    }

    public static <T> void fill(T[] arr, Runnable f) {
        f.run();
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        ArrayUtils.fill(arr, 0);
        System.out.println(Arrays.toString(arr));

        ArrayUtils.fill(arr, () -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += i;
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
=======
package febrary28.structure;

import java.util.Arrays;

/**
 * Created by Максим on 21.02.2017.
 */
public class ArrayUtils {
    public static <T> void fill(T[] arr, T obj) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = obj;
        }
    }

    public static <T> void fill(T[] arr, Runnable f) {
        f.run();
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        ArrayUtils.fill(arr, 0);
        System.out.println(Arrays.toString(arr));

        ArrayUtils.fill(arr, () -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += i;
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
>>>>>>> origin/master
