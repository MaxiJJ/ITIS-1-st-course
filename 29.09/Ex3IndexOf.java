class Ex3IndexOf {
    public static void main(String[] args) {

        int[] first = {8,236,67,87,23,517,1,6,4,9,87,87,16,6,6,4,8,6,8,236,67,87,23,57,64,
                4,9,39,5,981,8,236,67,87,23,57,65861,64,9,4,87,202,8,236,67,87,23,57,293,578,24,47,123,869,2623,41741};
        int[] second = {87,23,57,65861,64};
        int len = first.length;
        int len2 = second.length;

        if (len == 0 || len2 == 0) {
            System.out.print("Array length must be greater than zero");
            System.exit(0);
        }

        if (len2 > len) {
            System.out.print("Second array must be smaller than first.\nOtherwise it never enter");
            System.exit(0);
        }

        int k = 0;
        for (int i = 0; i < len; i++) {

            if (first[i] == second[0]) {
                for (int j = 0; j < len2; j++) {
                    if (i+j < len && first[i+j] == second[j]) k++;
                    else break;
                }
                if (k == len2) {
                    System.out.print("First entry index is: " + i);
                    System.exit(0);
                } else {
                    k = 0;
                }
            }

        }

        System.out.print("Array doesn't enter");
    }
}