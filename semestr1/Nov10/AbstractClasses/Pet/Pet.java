abstract class Pet {
    String name;
    int age;
    private boolean hungry = true;

    abstract void voice();

    void feed() {
        hungry = false;
    }

    boolean isHungry() {
        return hungry;
    }

    public String getName() {
        return name;
    }
}