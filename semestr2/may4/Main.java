package course1.may4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Максим on 25.05.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileWriter fileWriter = new FileWriter(new File("C:\\Users\\Максим\\Desktop\\futurlandGoods.json"));
        FuturlandParser.writeAllGoods(fileWriter);
        fileWriter.close();
    }
}
