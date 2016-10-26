class Monkey {
    private int age;
    private boolean hungry;
    protected String tool;
    protected String name;

    Monkey() {
    }

    Monkey(String name, int age, String tool) {
        this.name = name;
        this.age = age;
        this.tool = tool;
    }

    void walk() {
        System.out.println("I'm a monkey! I use 2 legs and 2 hand for walking.");
    }

    void destinationOfTool() {
        System.out.println(name + " use " + tool + " in order to survive and don't die of hunger");
    }

    void eatSomeFood() {
        hungry = false;
    }

    void dontEatForDay() {
        hungry = false;
    }

    //Getters and setters
    public boolean isHungry() {
        return hungry;
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

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }
}
