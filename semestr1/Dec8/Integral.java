public class Integral {
    public static float calculate(float a, float b, int n, FunctionAware function) {
        float sum = 0;
        final float dx = (b - a) / n;

        for (float i = a; i <= b; i += dx) {
            sum += function.calculateInPoint(i);
        }
        sum *= dx;
        return sum;
    }

    public static float calculateTrapeze(float a, float b, int n, FunctionAware function) {
        float sum = 0;
        final float dx = (b - a) / n;

        for (float i = a; i < b; i += dx) {
            sum += (function.calculateInPoint(i) + function.calculateInPoint(i + dx)) / 2;
        }
        sum *= dx;
        return sum;
    }

    public static float calculateSimpsonMethod(float a, float b, int n, FunctionAware function) {
        float sum = 0;
        final float dx = (b - a) / (2 * n);
        float evenSum = 0;
        float oddSum = 0;

        for (float i = a + 2 * dx; i < b; i += 2 * dx) {
            evenSum += function.calculateInPoint(i);
        }
        for (float i = a + dx; i < b; i += 2 * dx) {
            oddSum += function.calculateInPoint(i);
        }
        sum += function.calculateInPoint(a) + function.calculateInPoint(b) + 2 * evenSum + 4 * oddSum;
        sum *= (dx / 3);
        return sum;
    }
}
