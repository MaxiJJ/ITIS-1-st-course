public class Main {
    public static void main(String[] args) {
        Car c = new Car("BMW", "X6", 5000000);
        c.tryBreakDown(80);
        System.out.println(c.getRealPrice());
        c.go();

        UsedCar uc = new UsedCar("BMW", "X6", 5000000, 150000);
        System.out.println(uc.getMileage());
        System.out.println(uc.getRealPrice());
    }
}
