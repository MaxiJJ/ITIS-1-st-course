public class Main {
    public static void main(String[] args) {
        BMW bmw = new BMW("BMW", "X6", 4500000);
        VAZ taz = new VAZ("VAZ", "2101", 5000);

        System.out.println(bmw.getMark());
        System.out.println(bmw.getModel());
        bmw.go();
        bmw.tryBreakDown();
        System.out.println(taz.getMark());
        taz.go();
        System.out.println(taz.getCarType());
        System.out.println(taz.getRealPrice());
        taz.tryBreakDown();

    }
}
