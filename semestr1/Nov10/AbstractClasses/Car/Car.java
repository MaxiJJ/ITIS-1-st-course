import java.util.Random;

abstract class Car {
    private String mark;
    private String model;
    private int averagePrice;
    private int realPrice;
    int breakChance;

    Car(String mark, String model, int averagePrice) {
        this.mark = mark;
        this.model = model;
        if (averagePrice < 0) averagePrice = 0;
        this.averagePrice = averagePrice;
        realPrice = calculatePrice(averagePrice);
    }

    public abstract String getCarType();

    String getMark() {
        return mark;
    }

    String getModel() {
        return model;
    }

    int getRealPrice() {
        return calculatePrice(averagePrice);
    }

    private int calculatePrice(int averagePrice) {
        Random r = new Random();
        return averagePrice * (100 - r.nextInt(10)) / 100;
    }

    private boolean randomChance(int chance) {
        int luckyNum = (int) (Math.random() * chance);
        int num = (int) (Math.random() * chance);

        return luckyNum == num;
    }

    void tryBreakDown() {
        if (randomChance(breakChance)) {
            System.out.println("Oops! Now your car is like a bucket of bolts.");
        } else {
            System.out.println("Car in good condition.");
        }
    }


    void go() {
        System.out.println("A ron don don");
    }

    @Override
    public String toString() {
        return "Car mark: " + mark +
                ", model: " + model +
                ", price: " + realPrice +
                ", type of car: " + getCarType();
    }
}
