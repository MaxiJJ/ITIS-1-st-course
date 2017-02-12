package november3.diary;

import java.util.ArrayList;
import java.util.Calendar;

public class EventList {
    private static ArrayList<Event> events = new ArrayList<>();

    private EventList() {
    }

    public static void addEvent(Event event) {
        events.add(event);
    }

    public static String getDayEvents(Calendar date) {
        String res = "";
        Calendar start = (Calendar) date.clone();
        date.add(Calendar.DAY_OF_MONTH, 1);
        for (Event event : events) {
            // Is it in the time interval dd/mm/yyyy 00:00 - 23:59 ?
            if (event.getStartDate().compareTo(start) >= 0 && event.getStartDate().compareTo(date) < 0)
                res += event + "\n";
        }
        return res;
    }

    public static String getEventsForPeriod(Calendar start, Calendar end) {
        String res = "";

        for (Event event : events) {
            if (event.getStartDate().compareTo(start) >= 0 && event.getStartDate().compareTo(end) <= 0) {

                if (event.getFinishDate() != null && !(event.getFinishDate().compareTo(end) <= 0)) continue;
                res += event + "\n";
            }
        }
        return res;
    }

    public static String getAllEvents() {
        String res = "";
        for (Event event : events) {
            res += event + "\n";
        }
        return res;
    }

    public static ArrayList<Event> getEvents() {
        return events;
    }

    public static int getSize() {
        return events.size();
    }

    public static Event getEvent(int id) {
        return events.get(id - 1);
    }

    public static void editEvent(int id, String title, String description, Calendar start) {
        Event event = events.get(id - 1);
        if (!title.isEmpty()) event.setTitle(title);
        if (!description.isEmpty()) event.setDescription(description);
        if (start != null) event.setStartDate(start);
    }

    public static void editEvent(int id, String title, String description, Calendar start, Calendar finish) {
        editEvent(id, title, description, start);
        Event event = events.get(id - 1);
        if (start != null) event.setFinishDate(finish);
    }
}