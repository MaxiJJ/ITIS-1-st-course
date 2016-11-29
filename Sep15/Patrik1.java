class Patrik1 {
	
    public static void main(String[] args) {

        int count = Integer.parseInt(args[0]);

        if ( count > 1) {

        	for (int i = 0; i < count; i++){

        		for (int j = 0; j < count ; j++) {

        			System.out.print("*");

        		}

        		System.out.println(" ");
        	
        	}

        } else { 

        	System.out.print("Number must be greater than 0");

        }

    }

}