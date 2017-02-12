class CountNullInARow8 {

	public static void main(String[] args) {

		int input = Integer.parseInt(args[0]);
		int countOfNull = 0;
		int oneNum;
		int max = 0;

		if ( input > 0) {

			while (true) {

				if (input <= 0) break;

				oneNum = input % 2;

				if (oneNum == 0) countOfNull++;

				if (oneNum == 1) {

					if (countOfNull > max) {

						max = countOfNull;

					}

					countOfNull = 0;
				}

				input /= 2;
			}

			System.out.print("Max 0 of number in binary system is " + max);

		} else {

			System.out.print("Number must be greater than 0");
			
		} 

		
	}

}