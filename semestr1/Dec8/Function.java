public class Function implements FunctionAware {
    @Override
    public float calculateInPoint(final float x) {
        return x * (float) Math.sin(x);
    }
}
