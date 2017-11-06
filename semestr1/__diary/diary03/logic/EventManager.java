package course1.__diary.diary03.logic;

import course1.__diary.diary03.exceptions.IllegalDateFormatException;
import course1.__diary.diary03.exceptions.IllegalDatesSequenceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class EventManager {
    private EventList eventList = EventList.getInstance();

    private EventManager() {
    }

    private static class EventManagerHolder {
        public static final EventManager INSTANCE_HOLDER = new EventManager();
    }

    public static EventManager getInstance() {
        return EventManagerHolder.INSTANCE_HOLDER;
    }

    public void addEvent(boolean isOrdinaryEvent, String title, String description, String date)
            throws IllegalDatesSequenceException, IllegalDateFormatException {

        if (isOrdinaryEvent) {
            eventList.addEvent(new Event(title, description, scanOrdinaryDate(date)));
        } else {
            Calendar[] dates = scanDatePeriod(date);
            eventList.addEvent(new Event(title, description, dates[0], dates[1]));
        }
    }

    public void editEvent(int id, String title, String description, String date)
            throws IllegalDatesSequenceException, IllegalDateFormatException {

        if (eventList.getEvent(id).hasPeriod()) {
            Calendar[] dates = scanDatePeriod(date);
            eventList.editEvent(id, title, description, dates[0], dates[1]);
        } else {
            eventList.editEvent(id, title, description, scanOrdinaryDate(date));
        }

    }

    public ArrayList<String> showEvents() {
        ArrayList<String> stringEvents = new ArrayList<>();

        for (Event event : eventList.getEvents()) {
            stringEvents.add(event.toString());
        }

        return stringEvents;
    }

    // add 2 date in format dd/mm/yyyy hh:mm
    private Calendar[] scanDatePeriod(String date) throws IllegalDateFormatException, IllegalDatesSequenceException {
        int length = date.length();
        String[] dates = new String[2];
        final int oneDayPeriodDate = 30;
        final int minimal = 24;

        if (length < minimal) {
            throw new IllegalDateFormatException();
        }

        if (length < oneDayPeriodDate) {
            String day = date.substring(0, 10); // dd/mm/yyyy
            dates[0] = day + date.substring(10, 16); // dd/mm/yyyy hh:mm
            dates[1] = day + date.substring(18); // dd/mm/yyyy HH:MM

            // dd/mm/yyyy hh:mm - DD/MM/YYYY HH:MM
        } else {
            dates[0] = date.substring(0, 16); // dd/mm/yyyy hh:mm
            dates[1] = date.substring(19); // DD/MM/YYYY HH:MM
        }

        Calendar start;
        Calendar finish;

        start = scanDate(dates[0], Event.PERIOD_EVENT);
        finish = scanDate(dates[1], Event.PERIOD_EVENT);

        if (!(start.before(finish) || start.equals(finish))) {
            throw new IllegalDatesSequenceException();
        }
        return new Calendar[]{start, finish};
    }

    // add date in format dd/mm/yyyy
    private Calendar scanOrdinaryDate(String date) throws IllegalDateFormatException {
        return scanDate(date, Event.DAY_EVENT);
    }

    private Calendar scanDate(String date, String dateFormat) throws IllegalDateFormatException {
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        format.setLenient(false);

        try {
            calendar.setTime(format.parse(date));
        } catch (ParseException e) {
            throw new IllegalDateFormatException();
        }
        return calendar;
    }
}