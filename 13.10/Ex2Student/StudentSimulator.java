class StudentSimulator {
    public static void main(String[] args) {
        University university = new University("КФУ", "Казань", 10);
        Food food = new Food();
        food.addFood(new String[]{"Жаренная курочка", "Трехнедельные печеньки", "Растаявший сникерс","Дошик",
        	"Дошик","Дошик","Дошик","Дошик","Дошик","Дошик","Дошик","Дошик","Дошик","Дошик","Дошик"});
        Student student = new Student("Максим", 18, university, food, 30);
        student.wakeUp(6);
        student.wakeUp(8);
        student.eatSomeFood();
        System.out.println(student.code());
        if (!student.tryToStudy() && !student.tryToBuyFood("Coffee",35)) {
            student.goSleep();
            student.tryToSkipLesson();
        }
        student.isStillStudent();
    }
}
