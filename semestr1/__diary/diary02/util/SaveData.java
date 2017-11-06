package course1.__diary.diary02.util;

import course1.__diary.diary02.EventList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveData {
    public static void save() {
        String fileName = System.getProperty("user.home") + System.getProperty("file.separator") + "events.ser";
        try (FileOutputStream fs = new FileOutputStream(fileName);
             ObjectOutputStream os = new ObjectOutputStream(fs)) {

            os.writeObject(EventList.getEvents());
            System.out.println("Events was successfully saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}