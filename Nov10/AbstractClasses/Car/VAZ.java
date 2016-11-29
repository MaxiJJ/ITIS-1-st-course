class VAZ extends Car {
    VAZ(String mark, String model, int averagePrice) {
        super(mark, model, averagePrice);
        breakChance = 10;
    }

    @Override
    void go() {
        System.out.println("Something go wrong, wrong.");
    }

    @Override
    public String getCarType() {
        return "BPAN. Potsansky taz ";
    }
}
