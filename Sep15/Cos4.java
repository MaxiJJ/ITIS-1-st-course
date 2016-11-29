public class Cos4 {

    public static void main(String[] args) {

        int count = Integer.parseInt(args[0]);
        double x = Double.parseDouble(args[1]);

        if (count > 0) {
	        double sum = 0;

	        for ( int i = 1; i <= count; i++ ) {

	        	sum = Math.cos(x + sum);

	        }

	        System.out.printf("Result is %.5f", sum);
	        
	    } else {

	    	System.out.print("Count must be greater than 0");

	    }

    }

}
