class Cat extends Pet {

    Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    void voice() {
        System.out.println("Meow");
    }
}
