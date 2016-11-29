class ToN36System7 {

    public static void main(String[] args) {

        int[] num = {10,11,12,13,14,15,16,17,18,19,20,
                21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};

        String[] symbol = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        int input = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int sumOfNum = 0;
        int oneNum;
        String reversedRes = "";
        String reversedSumRes = "";

        if ( input > 0 && k >= 2 && k <= 36) {

            while (input != 0) {

                oneNum = input % k;
                sumOfNum += oneNum;

                if (oneNum < 10) {

                    reversedRes += oneNum;

                } else {

                    reversedRes += symbol[oneNum - 10];

                }

                input /= k;

            }

            while (sumOfNum != 0) {

                oneNum = sumOfNum % k;

                if (oneNum < 10) {

                    reversedSumRes += oneNum;

                }

                else {

                    reversedSumRes += symbol[oneNum - 10];

                }

                sumOfNum /= k;

            }
            char [] res = reversedRes.toCharArray();
            char [] sumRes = reversedSumRes.toCharArray();

            System.out.print("Number in " + k + " system is ");


            for (int i = reversedRes.length() - 1; i >= 0 ; i--) {

                System.out.print(res[i]);

            }

            System.out.println();

            System.out.print("Count of digits in num is ");

            for (int i = reversedSumRes.length() - 1; i >= 0 ; i--) {

                System.out.print(sumRes[i]);

            }

        } else {

            System.out.println("Number must be greater than 0 and notation in range [2;36]");

        }

    }

}