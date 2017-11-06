package course1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Exam1 {
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
        Map<String, Integer> wordMap = countWords(text.toString());
        System.out.println(wordMap);
    }


    private static Map<String, Integer> countWords(String text) {
        text = text.toLowerCase();
        String[] words = text.split(" ");
        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            Integer key = wordMap.get(word);
            if (key == null) key = 0;

            wordMap.put(word, key + 1);
        }

        return wordMap;
    }
}
