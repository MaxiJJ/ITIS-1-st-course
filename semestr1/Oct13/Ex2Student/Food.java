class Food {
    private static final int CAPACITY = 15;

    private static int countOfFood = 0;
    private String[] food = new String[CAPACITY];


    private boolean isFull() {
        return countOfFood >= CAPACITY;
    }

    void addFood(String food) {
        if (!isFull()) {
            this.food[countOfFood] = food;
            countOfFood++;
        } else {
            System.out.println("You have a lot more food than the ordinary student. Perhaps you want to share it?");
        }
    }

    void addFood(String[] foods) {
        for (String food : foods) {
            addFood(food);
            if (isFull()) break;
        }
    }

    String getRandomFood() {
        int random = (int) (Math.random()*countOfFood);
        return food[random] != null?food[random]:getRandomFood();
    }

    void removeFood(String food) {
        for (int i = 0; i < countOfFood; i++) {
            if (this.food[i].equals(food)) {
                System.arraycopy(this.food,i + 1, this.food, i, CAPACITY - i - 1);
                countOfFood--;
                System.out.println("Food: " + food + " was eaten.");
                return;
            }
        }
        System.out.println("Can't find this food. Maybe you forgot to buy it?");
    }
}
