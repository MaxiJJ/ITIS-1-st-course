class Ex3IndexOf {
    public static void main(String[] args) {

        int[] first = {8,236,67,87,23,517,1,6,4,9,87,87,16,6,6,4,8,6,8,236,67,87,23,57,64,
        	4,9,39,5,981,8,236,67,87,23,57,65861,64,9,4,87,202,8,236,67,87,23,57,293,578,24,47,123,869,2623,4};
        int[] second = {8,236,67,87,23,57};
        int len = first.length - 1;
        int len2 = second.length;
        int index = len2 - 1;

        for (int i = 0, k = 1; i <= len; i++) {

            if (k == len2) break;
            if (first[i] == second[0] && !(first[index + k] == second[k])) index = i;
            if (first[index + k] == second[k]) k++;

        }

        if (index == len2 - 1) System.out.print("Array doesn't enter");
        else System.out.print("First entry index is: " + index);
    }
}