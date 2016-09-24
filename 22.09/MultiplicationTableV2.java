class MultiplicationTableV2 {

    public static void main (String[] args) {

        int count = Integer.parseInt(args[0]);

        int numOfDigit;
        int maxNumOfDigit = String.valueOf(count * count).length();

        for (int i=1; i <= count; i++){

            for (int j=1; j <= count; j++){

                System.out.print(i * j);
                System.out.print("  ");

                numOfDigit = String.valueOf(i*j).length();

                for (; numOfDigit <= maxNumOfDigit ; numOfDigit ++) System.out.print(" ");

            }

            System.out.println();

        }

    }

}