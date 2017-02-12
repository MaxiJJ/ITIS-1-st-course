class Student {
    private String name;
    private int age;
    private University univer ;
    private boolean isSleep = true;
    private int money;
    private Food food;

    Student() {}
    Student(String name) {
        this.name = name;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Student(String name, int age, University univer) {
        this.name = name;
        this.age = age;
        this.univer = univer;
    }

    Student(String name, int age, University univer, Food food, int money) {
        this.name = name;
        this.age = age;
        this.univer = univer;
        this.food = food;
        this.money = money;
    }

    boolean isSleep() {
        return isSleep;
    }

    void goSleep() {
        isSleep = true;
    }

    void wakeUp(int time) {
        if (!isSleep()) System.out.println("You don't sleep");
        else if (time >= 7 && time <= 24) isSleep = false;
        else System.out.println("Too early.");

    }

    String code() {
        return "Let's some code!" +
                "\n" +
                "public class Main{\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World!\");\n" +
                "    }\n" +
                "}";
    }

    boolean tryToStudy() {
        if (randomChance()) {
            System.out.println("You are LUCKY! You could concentrate on studies and understand all!");
            return true;
        }
        System.out.println("You couldn't understand anything and concentrate on studies. So you really wanna sleep.");
        return false;
    }

    boolean tryToBuyFood(String food, int cost) {
        if (money >= cost) {
            money -= cost;
            this.food.addFood(food);
            return true;
        } else {
            System.out.println("Sorry, You don't have enough money.");
            return false;
        }
    }

    void eatSomeFood() {
        this.food.removeFood(this.food.getRandomFood());
    }

    void tryToSkipLesson() {
        if (randomChance()) {
            univer = null;
            System.out.println("You were caught in skipping lesson.");
        } else {
            System.out.println("Good job! No one noticed your absence.");
        }
    }

    void isStillStudent() {
        if (univer != null) System.out.println("You are still student!");
        else System.out.println("Game Over. Ты был отчислен :(");
    }

    private boolean randomChance() {
        int luckyNum = (int) (Math.random()*10);
        int num = (int) (Math.random()*10);

        return luckyNum == num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University getUniver() {
        return univer;
    }

    public void setUniver(University univer) {
        this.univer = univer;
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}