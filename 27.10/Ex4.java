import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String cleanText = line.replaceAll("[^()]", "");
        System.out.println(isRightLine(cleanText, 0, 0));
    }

    static boolean isRightLine(String line, int count, int i) {
        char tmp = line.charAt(i);
        if (tmp == '(') count++;
        else count--;

        if (count < 0) return false;
        if (i != line.length() - 1) return isRightLine(line, count, i + 1);
        return count == 0;
    }
}
