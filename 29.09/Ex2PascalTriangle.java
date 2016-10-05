class Ex2PascalTriangle {

    public static void main(String[] args) {

        int num = 10;
        int Cnk;

        for (int n = 0; n <= 10; n++) {

            for (int i = 0; i <= (num - n - 1); i++) {
                System.out.print("  ");
            }

            Cnk = 1;
            System.out.print(Cnk);

            for (int k = 1; k <= n; k++) {
                Cnk *= (n - k + 1);
                Cnk /= k;
                System.out.printf("%4d", Cnk);
            }
            System.out.println();
        }
    }
}