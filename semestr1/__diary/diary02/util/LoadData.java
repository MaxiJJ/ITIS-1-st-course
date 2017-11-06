package course1.__diary.diary02.util;

import course1.__diary.diary02.Event;
import course1.__diary.diary02.EventList;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LoadData {
    public static void load() {
        String fileName = System.getProperty("user.home") + System.getProperty("file.separator") + "events.ser";
        try (FileInputStream fs = new FileInputStream(fileName);
             ObjectInputStream os = new ObjectInputStream(fs)) {

            Object one = os.readObject();
            ArrayList<Event> events = (ArrayList<Event>) one;
            restoreEvents(events);
            System.out.println("Events was successfully loaded");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void restoreEvents(ArrayList<Event> events) {
        int idCounter = Event.getIdCounter();
        for (Event event : events) {
            event.setId(idCounter++);
            EventList.addEvent(event);
        }
        Event.setIdCounter(idCounter);
    }
}