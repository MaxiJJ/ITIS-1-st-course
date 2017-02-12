class Circle0 {

    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);

        if ( a > 0) {

        	double P = Math.PI * a* 2;
        	double S = (Math.PI * a*a);

        	System.out.print(P, S);

        } else if (a == 0) {

        	System.out.print("Circle radius is zero, so circle is dot");

        } else {

        	System.out.print("Radius must be greater than 0");

        }

    }
    
}