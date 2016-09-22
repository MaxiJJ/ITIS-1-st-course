class ToBinarySystem5 {

	public static void main(String[] args) {

		int input = Integer.parseInt(args[0]);
		int countOfOne = 0;
		double result = 0;
		int oneNum;
		int countOfIteration = 0;

		if ( input >= 0) {

			while (input != 0) {

				oneNum = input % 2;

				if (oneNum == 1) {

					countOfOne++;

				}

				result += oneNum * Math.pow(10.0,(countOfIteration));
				countOfIteration++;
				input /= 2;

			}

			System.out.println("Count of 1 in num is " + countOfOne);
        	System.out.print("Number in binary system is " + (int) result);

		} else {

			System.out.println("Number must be greater than 0");

		}

	}

}