package course1.april6;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by Максим on 13.04.2017.
 */
public class CharacterIO {
    private Path path;

    public CharacterIO(Path path) {
        this.path = path;
    }

    public static void main(String[] args) {
        CharacterIO characterIO = new CharacterIO(Paths.get("C:\\Users\\Максим\\Desktop\\1.txt"));
        characterIO.write(new char[]{'m', 'a', 'x'});
        char[] array = characterIO.read();
        System.out.println(Arrays.toString(array));
    }

    public void write(char[] chars) {
        try (Writer fileWriter = new FileWriter(new File(path.toUri()))) {
            fileWriter.write(chars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public char[] read() {
        char[] charArr = new char[10];
        try (Reader fileReader = new FileReader(new File(path.toUri()))) {
            for (int i = 0; i < charArr.length; i++) {
                charArr[i] = (char) fileReader.read();
            }
            return charArr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
