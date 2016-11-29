class Human extends Monkey {

    private int money;
    private String city;

    Human(String name, int age, String tool, int money, String city) {
        super(name, age, tool);
        this.money = money;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public int getMoney() {
        return money;
    }

    @Override
    void walk() {
        System.out.println("I'm a human! I use 2 legs for walking and my hands ");
    }

    @Override
    void destinationOfTool() {
        System.out.println(name + " use " + tool + " in order to earn money");
    }

    void spendMoney(int count, String item) {
        if (money >= count) {
            money -= count;
            System.out.println("You buy " + item + " and spend " + count + " rub.");
        } else {
            System.out.println("You don't have enough money.");
        }
    }

    void goJob(int hours, int moneyPerH) {
        money += hours * moneyPerH;
    }
}
