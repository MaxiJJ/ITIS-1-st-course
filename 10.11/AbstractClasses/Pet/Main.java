public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Murzik", 2);
        Dog dog = new Dog("Sharik", 2);

        System.out.println(cat.getName());
        cat.voice();
        cat.feed();
        System.out.println(cat.isHungry());
        dog.getName();
        dog.voice();
    }
}
