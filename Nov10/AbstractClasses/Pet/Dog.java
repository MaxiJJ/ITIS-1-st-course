class Dog extends Pet {

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    void voice() {
        System.out.println("Woof");
    }
}
