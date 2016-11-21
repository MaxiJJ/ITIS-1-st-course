public class Dynasty {
    public static void main(String[] args) {
        int startGen = 2;
        int childInGenCount = 1;
        int multiplier = 10;
        int sum = 0;

        int gen = 5;
        System.out.println("Sum of children in " + gen + " generation: " 
                + countChild(startGen, gen, childInGenCount, multiplier, sum));
    }

    static int countChild(int currentGen, int gen, int childInGenCount, int multiplier, int sum) {
        if (currentGen > gen) return sum;

        childInGenCount *= multiplier;
        multiplier += currentGen % 2 == 1 ? 1 : -2;
        sum += childInGenCount;
        return countChild(currentGen + 1, gen, childInGenCount,multiplier,sum);
    }
}