public class Main {
    public static void main(String[] args) {
        FunctionAware function = new Function();

        for (int i = 10; i <= 1000; i *= 10) {
            System.out.println("N = " + i);
            System.out.println("Triangle method: " + Integral.calculate(0, 10, i, function));
            System.out.println("Trapeze method: " + Integral.calculateTrapeze(0, 10, i, function));
            System.out.println("Simpson method: " + Integral.calculateSimpsonMethod(0, 10, i, function));
            System.out.println("_____________________________________");
        }
    }
}