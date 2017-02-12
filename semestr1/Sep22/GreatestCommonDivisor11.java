class GreatestCommonDivisor11 {

	public static void main(String[] args) {

        int firstNum = Integer.parseInt(args[0]);
        int secondNum = Integer.parseInt(args[1]);

        if (firstNum < 0 || secondNum < 0) {

            System.out.print("Number must be greater than 0");

        } else {

            long evklidTime = evklidMethod(firstNum, secondNum);
            long bfTime = bruteForce(firstNum, secondNum);

            if (evklidTime < bfTime) {

                System.out.print("Evklid method is faster");

            } else if (evklidTime == bfTime) {

                System.out.print("Both method have same time");

            } else {

                System.out.print("Bruteforce is faster");

            }

        }

    }

    public static long evklidMethod(int firstNum, int secondNum) {

        long start = System.currentTimeMillis();


        while (firstNum != 0 && secondNum != 0) {

            if ( firstNum > secondNum) {

                firstNum -= secondNum; //firstNum %= secondNum;

            } else {

                secondNum -= firstNum; //secondNum %= firstNum;

            }

        }

        System.out.printf("Greatest Common Divisor is %d \n", firstNum + secondNum );

        long finish = System.currentTimeMillis();
        long time = finish - start;

        return time;

    }

    
    

    public static long bruteForce(int firstNum, int secondNum) {

        long start = System.currentTimeMillis();

        int gcd = 0;
        int min = Math.min(firstNum,secondNum);

        for (int i = 1; i <= min; i++) {

            if (firstNum % i == 0 && secondNum % i == 0 && i > gcd) {

                gcd = i;

            }

        }

        //System.out.printf("Greatest Common Divisor is %d",gcd);

        long finish = System.currentTimeMillis();
        long time = finish - start;

        return time;

    }

}