class Table2 {

    public static void main(String[] args) {

        int count = Integer.parseInt(args[0]);

        if ( count > 0) {

        	for (int i = 1; i <= count; i++){

            	for (int j = 1; j <= count ; j++) {

               	 System.out.printf("%4d", i*j);

           	 }

            	System.out.println("");

        	}

        } else {

        	System.out.print("Number must be greater than 0");
        	
        }

    }

}