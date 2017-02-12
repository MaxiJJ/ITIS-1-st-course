class StarCircle13 {

	public static void main(String[] args){

        int r = 5;
        //int r = Integer.parseInt(args[0]);

        for (int x = 0; x <= 2 * r; x++){

            for (int y = 0; y <= 2 * r; y++){

                if ((x - r) * (x - r) + (y - r) * (y - r) < r * r) {

                    System.out.print("**");

                }

                else {

                    System.out.print("  ");

                }

            }

            System.out.println();
            
        }
    }

}    
      
     
     
      
        
          
