class SumOfFactorial3 {

	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		double sum = 0;
		double fact1 = 1;
		double fact2 = 1;

		if ( n < 1) {

			System.out.print("Number must be > or = 1");

		} else {

			for ( int m = 1; m <= n; m++) {

				for ( int i = 1; i < m-1; i++) {
					fact1 *= (i+1);
				}


				for ( int j = 1; j < 2 * m; j++) {
					fact2 *= (j+1);
				}

				sum += (fact1*fact1)/fact2;

				fact1 = 1;
				fact2 = 1;

			}

		}

		System.out.print("Sum of " + n + " element is " + sum);
		
	}

}