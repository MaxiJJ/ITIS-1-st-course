public class Third3 {

    public static void main(String[] args) {

        int count = Integer.parseInt(args[0]);

        if (count > 0) {

            double sum = 1;

            for (int i = 1; i < count; i++) {

                if (i % 2 == 1) {

                    sum -= (1.0/(((2*i) + 1) *(2*i) + 1));

                } else {

                    sum += (1.0/(((2*i) + 1) *(2*i) + 1));

                }

            }

            System.out.printf("Sum of %d element is %.5f", count, sum);

        } else {

            System.out.print("Count must be greater than 0");
            
        }
        
    }

}
