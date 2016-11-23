import java.util.Scanner;

public class Dynasty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startGen = 1;
        int childInGenCount = 1;
        int multiplier = 10;
        int sum = 0;

        int gen = sc.nextInt();
        System.out.print("Sum of children in " + gen + " generation: "
                + countChild(startGen, gen, childInGenCount, multiplier, sum));
    }



    static int countChild(int currentGen, int gen, int childInGenCount, int multiplier, int sum) {
        if (currentGen > gen) return sum;
        if (multiplier < 2) multiplier = 2;
        childInGenCount *= multiplier;
        multiplier += currentGen % 2 == 0 ? 1 : -2;
        sum += childInGenCount;
        return countChild(currentGen + 1, gen, childInGenCount, multiplier, sum);
    }
}