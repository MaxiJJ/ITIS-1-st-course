import java.util.Arrays;

class Ex1Buble {

    public static void main(String[] args) {
        int arrayLength = 20;
        int[] a = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            a[i] = (int) (Math.random() * 100);
        }
        boolean isSorted = false;
        int swap;

        while(!isSorted) {

            isSorted=true;

            for (int i = 0; i < a.length - 1; i++) {

                if (a[i] > a[i+1]) {

                    swap = a[i+1];
                    a[i+1] = a[i];
                    a[i] = swap;
                    isSorted=false;

                }
            }
        }

        System.out.print(Arrays.toString(a));

    }
}