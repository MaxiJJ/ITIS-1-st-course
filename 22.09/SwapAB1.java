class SwapAB1 {

	public static void main(String[] args) {

		int a = 5;
		int b = 7;

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.printf("A is %d, B is %d", a, b);
		
	}

}