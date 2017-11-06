package course1;

/**
 * Created by Максим on 02.01.2017.
 */
public class Bullshit {
    public static void main(String[] args) {
        flag: for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(j + " ");
                if (j == 10) {
                    break flag;
                }
            }
            System.out.println();
        }
    }
}