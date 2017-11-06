package course1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Exam2 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Максим\\Desktop\\text.txt");
        try {
            printWordStatistic(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printWordStatistic(File file) throws IOException {
        StringBuilder text = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line);
            }
        }
        Map<Character, Integer> wordMap = countWords(text.toString());
        System.out.println(wordMap);
    }


    private static Map<Character, Integer> countWords(String text) {
        text = text.toLowerCase();
        char[] chars = text.toCharArray();
        Map<Character, Integer> wordMap = new HashMap<>();

        for (Character character : chars) {
            if (!Character.isLetter(character)) continue;

            Integer key = wordMap.get(character);
            if (key == null) key = 0;

            wordMap.put(character, key + 1);
        }

        return wordMap;
    }
}
