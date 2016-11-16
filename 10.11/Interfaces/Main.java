public class Main {
    public static void main(String[] args) {
        Catapult catapult = new Catapult();
        SwordBearer sb = new SwordBearer();

        Fightable[] arr = new Fightable[2];
        arr[0] = catapult;
        arr[1] = sb;

        for (Fightable fightable : arr) {
            fightable.fight();
        }

        sb.defense();
        sb.run();
        sb.camouflage();
    }
}
