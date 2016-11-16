class SwordBearer implements WarriorInterface {
    @Override
    public void run() {
        System.out.println("My armor is too heavy, so I'm running slowly");
    }

    @Override
    public void fight() {
        System.out.println("I can kill anyone with a sword");
    }

    @Override
    public void defense() {
        System.out.println("I have a shield, so I can parry hit");
    }

    @Override
    public void camouflage() {
        System.out.println("I can camouflage in the bushes");
    }
}
