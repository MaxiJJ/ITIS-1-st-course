package course1.april13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVManager {
    private File file;
    private String delimetr = ",";

    public CSVManager(File csvFile) {
        this.file = csvFile;
    }

    public String[][] readFile() throws IOException {
        List<String[]> arrayOfStrings = new ArrayList<>();
        Scanner sc = new Scanner(file);
        String line;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] data = line.split("\"" + delimetr + "\"");
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i].replaceAll("\\\\\"", "\"");
            }
            arrayOfStrings.add(data);
        }
        sc.close();

        String[][] separatedLines = new String[arrayOfStrings.size()][arrayOfStrings.get(0).length];
        return arrayOfStrings.toArray(separatedLines);
    }

    public void writeFile(String[][] format) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (String[] strings : format) {
            for (int j = 0; j < strings.length - 1; j++) {
                strings[j] = strings[j].replaceAll("\"", "\\\\\"");
                writer.write("\"" + strings[j] + "\"" + delimetr);
            }
            writer.write("\"" + strings[strings.length - 1] + "\"");
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }
}
