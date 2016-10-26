public class Evolution {
    public static void main(String[] args) {
        Human human = new Human("Maxim", 18, "Laptop and internet", 500, "Kazan");
        System.out.println(human.getName());
        System.out.println(human.getAge());
        System.out.println(human.getMoney());
        System.out.println(human.getCity());
        human.eatSomeFood();
        System.out.println(human.isHungry());
        human.destinationOfTool();
        human.goJob(8, 1500);
        human.walk();
        human.spendMoney(10999, "Smartphone from Eldorado");
    }
}
