import java.util.Random;

class Car implements Cloneable {
    protected String mark;
    protected String model;
    private int averagePrice;
    protected int realPrice;


    public Car(String mark, String model, int averagePrice) {
        this.mark = mark;
        this.model = model;
        if (averagePrice < 0) averagePrice = 0;
        this.averagePrice = averagePrice;
        realPrice = calculatePrice(averagePrice);
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public int getRealPrice() {
        return realPrice;
    }

    protected int calculatePrice(int averagePrice) {
        Random r = new Random();
        return (int) (averagePrice * (100 - r.nextInt(10))/100);
    }

    private boolean randomChance(int chance) {
        int luckyNum = (int) (Math.random()*chance);
        int num = (int) (Math.random()*chance);

        return luckyNum == num;
    }

    void tryBreakDown(int chance) {
        if (randomChance(chance)) {
            System.out.println("Oops! Something go wrong.");
        } else {
            System.out.println("Car in good condition.");
        }
    }


    void go() {
        System.out.println("A ron don don");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (averagePrice != car.averagePrice) return false;
        if (realPrice != car.realPrice) return false;
        if (!mark.equals(car.mark)) return false;
        return model.equals(car.model);

    }

    @Override
    public int hashCode() {
        int result = mark.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + averagePrice;
        result = 31 * result + realPrice;
        return result;
    }

    @Override
    public String toString() {
        return "Car mark: " + mark +
                ", model: " + model +
                ", price: " + realPrice;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
