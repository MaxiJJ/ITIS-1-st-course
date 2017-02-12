class DividersOfNum9 {

	public static void main(String[] args) {

		int input = Integer.parseInt(args[0]);

		if (input > 0) {

			for ( int i = 1; i <= (int) Math.sqrt(input); i++) {

				if (input % i == 0) {

					System.out.print(i + " ");

					if (i != (input / i)) System.out.print((input / i) + " ");
				}

			}

		} else {

			System.out.print("Number must be greater than 0");
			
		}

	}

}