class Ex5IndexOfString {
    public static void main(String[] args) {

        String first = args[0];
        String second = args[1];
        int len = first.length();
        int len2 = second.length();
        char[] fArr = first.toCharArray();
        char[] sArr = second.toCharArray();

        if (len == 0 || len2 == 0) {
            System.out.print("String length must be greater than zero");
            System.exit(0);
        }

        if (len2 > len) {
            System.out.print("Second string must be smaller than first.\nOtherwise it never enter");
            System.exit(0);
        }

        int k = 0;
        for (int i = 0; i < len; i++) {

            if (fArr[i] == sArr[0]) {
                for (int j = 0; j < len2; j++) {
                    if (i+j < len && fArr[i+j] == sArr[j]) k++;
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

        System.out.print("String doesn't enter");

    }
}