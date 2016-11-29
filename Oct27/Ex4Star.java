import java.util.Scanner;

public class Ex4Star {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String cleanText = line.replaceAll("[^(){}\\[\\]]", "");
        String[] braces = {"()", "{}", "[]"};
        System.out.println(isRightLine(cleanText, "", braces));
    }

    static boolean isRightLine(String cleanText, String tmp, String[] braces) {
        tmp = cleanText;
        for (String brace : braces) {
            cleanText = cleanText.replace(brace, "");
        }

        if (!cleanText.equals(tmp)) return isRightLine(cleanText, tmp, braces);
        return cleanText.isEmpty();
    }


}
