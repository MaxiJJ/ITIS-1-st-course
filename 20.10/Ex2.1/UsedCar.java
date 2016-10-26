class UsedCar extends Car implements Cloneable {

    private int mileage;

    public UsedCar(String mark, String model, int averagePrice, int mileage) {
        super(mark, model, averagePrice);
        if (mileage < 0) mileage = 0;
        this.mileage = mileage;

    }

    public int getMileage() {
        return mileage;
    }

    @Override
    protected int calculatePrice(int averagePrice) {
        int res = super.calculatePrice(averagePrice);
        res -= mileage;
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UsedCar usedCar = (UsedCar) o;

        return mileage == usedCar.mileage;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + mileage;
        return result;
    }

    @Override
    public String toString() {
        return "Used Car mark: " + mark +
                ", model: " + model +
                ", price: " + realPrice +
                ", mileage: " + mileage;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
