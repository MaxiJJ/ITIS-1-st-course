class BMW extends Car {

    BMW(String mark, String model, int averagePrice) {
        super(mark, model, averagePrice);
        breakChance = 80;
    }

    @Override
    void go() {
        System.out.println("VRUM VRUM VRUM VRUUUUUUUUUUUUM VRUM");
    }

    @Override
    public String getCarType() {
        return "Normal car";
    }
}
