public class Well5 {

	public static void main(String[] args) {

		int time = Integer.parseInt(args[0]);

		if ( time > 0) {

			System.out.print("Depth of well is " + (9.8 * time * time) / 2);

		} else {

			System.out.print("Time must be greater than 0");

		}

	}
	
}