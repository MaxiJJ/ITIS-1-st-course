class ToNSystem6 {

	public static void main(String[] args) {

		int input = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		int sumOfNum = 0;
		double result = 0;
		double result2 = 0;
		int oneNum;
		int countOfIteration = 0;

		if ( input > 0 && k >= 2 && k <= 10) {

			while (input != 0) {

				oneNum = input % k;

				if (oneNum > 0) sumOfNum += oneNum;

				result += oneNum * Math.pow(10.0 , (countOfIteration));
				countOfIteration++;
				input /= k;

			}

			countOfIteration = 0;

			while (sumOfNum != 0) {

				oneNum = sumOfNum % k;

				result2 += oneNum * Math.pow(10.0 , (countOfIteration));
				countOfIteration++;
				sumOfNum /= k;

			}

			System.out.println("Count of digits in num is " + (int) result2);
        	System.out.print("Number in " + k + " system is " + (int) result);

		} else {

			System.out.println("Number must be greater than 0 and notation in range [2;10]");

		}

	}

}