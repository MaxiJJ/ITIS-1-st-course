import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Point {
    private int x = 0;
    private int y = 0;
    private int x1 = 0;
    private int y1 = 0;

    void getPointFile() {
        File file = new File("C:\\text.txt");
        try (Scanner sc = new Scanner(file)) {
            sc.useDelimiter(", ");
            this.x = sc.nextInt();
            this.y = sc.nextInt();
            this.x1 = sc.nextInt();
            this.y1 = sc.nextInt();
        } catch (FileNotFoundException e) {
            System.out.println("Some problems: " + e);
        }
    }

    void getPointConsole() {
        Scanner sc = new Scanner(System.in);
        this.x = sc.nextInt();
        this.y = sc.nextInt();
        this.x1 = sc.nextInt();
        this.y1 = sc.nextInt();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }
}
