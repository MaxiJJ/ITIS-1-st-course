class Ex4CompareTo2 {
    public static void main(String[] args) {

        String first = args[0];
        String second = args[1];
        char[] fArr = first.toCharArray();
        char[] sArr = second.toCharArray();
        String res = "";

        if (first.length() == 0 || second.length() == 0) {
            System.out.print("String length must be greater than zero");
            System.exit(0);
        }

        for (int i = 0; i < Math.min(first.length(), second.length());i++) {
            if (fArr[i] < sArr[i]) {
                res = first + "\n" + second;
                break;
            }
            else if (fArr[i] > sArr[i]) {
                res = second + "\n" + first;
                break;
            }
        }
        if (res.length() > 0) System.out.print(res);
        else if (first.length() - second.length() > 0) System.out.print(second + "\n" + first);
        else System.out.print(first + "\n" + second);
    }
}