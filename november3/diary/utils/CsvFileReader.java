package november3.diary.utils;

import november3.diary.Event;
import november3.diary.EventList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CsvFileReader {

    /** Delimiter used in CSV file. */
    private static final String COMMA_DELIMITER = ",";

    /** Event attributes indexes. */
    private static final int EVENT_TITLE = 1;
    private static final int EVENT_DESCRIPTION = 2;
    private static final int EVENT_DATE = 3;

    /**
     * Read data from CSV file and create Event object(s).
     */
    public static void readCsvFile() {
        String fileName = System.getProperty("user.home") + System.getProperty("file.separator") + "events.csv";
        BufferedReader fileReader = null;
        try {
            //Create a new list of events to be filled by CSV file data
            ArrayList<Event> events = new ArrayList<>();
            String line;

            fileReader = new BufferedReader(new FileReader(fileName));
            //Read the CSV file header to skip it
            fileReader.readLine();
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new event object and fill his data
                    Calendar[] calendars = parseDate(tokens[EVENT_DATE]);
                    Event event;
                    if (calendars[1] == null) {
                        event = new Event(tokens[EVENT_TITLE], tokens[EVENT_DESCRIPTION], calendars[0]);
                    } else {
                        event = new Event(tokens[EVENT_TITLE], tokens[EVENT_DESCRIPTION], calendars[0], calendars[1]);
                    }
                    events.add(event);
                }
            }

            int skippedCount = 0;
            for (Event event : events) {
                if (!(EventList.getEvents().contains(event))) {
                    int id = event.getId();
                    event.setId(id - skippedCount);
                    EventList.addEvent(event);
                    Event.setIdCounter(id - skippedCount + 1);
                } else {
                    skippedCount++;
                }
            }

            //Print the events list
            events.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error in CsvFileReader!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader!");
                e.printStackTrace();
            }
        }
    }

    /**
     * Parse Calendar objects from String.
     *
     * @param date
     *        Event date(s).
     *
     * @return Array of Calendar object.
     *
     * @throws IOException
     *         if date format incorrect.
     */
    private static Calendar[] parseDate(String date) throws IOException {
        Calendar start = Calendar.getInstance();
        Calendar end = null;
        start.setLenient(false);

        String[] dates = processDate(date);
        String startDate = "";
        String endDate = "";
        String dateFormat = "";

        if (dates.length < 1) throw new IOException("Wrong date format");
        if (dates.length == 2) {
            dateFormat = dates[0];
            startDate = dates[1];
        }
        if (dates.length == 3) {
            dateFormat = dates[0];
            startDate = dates[1];
            endDate = dates[2];

            end = Calendar.getInstance();
            end.setLenient(false);
        }

        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        format.setLenient(false);

        try {
            start.setTime(format.parse(startDate));
            if (end != null) {
                end.setTime(format.parse(endDate));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Calendar[]{start, end};
    }

    /**
     * Handles line and extracts the date format and the dates of events.
     *
     * @param date
     *        date in String format.
     *
     * @return String array that contains date format(zero index) and date(s) of the event.
     */
    private static String[] processDate(final String date) {
        int length = date.length();
        String[] dates = null;
        final int ordinaryDate = 20;
        final int oneDayPeriodDate = 30;

        if (length > 0) {

            // dd/mm/yyyy
            if (length < ordinaryDate) {
                dates = new String[2];
                dates[0] = Event.DAY_EVENT;
                dates[1] = date;

            // dd/mm/yyyy hh:mm - HH:MM
            } else if (length < oneDayPeriodDate) {
                dates = new String[3];
                String day = date.substring(0, 10); // dd/mm/yyyy
                dates[0] = Event.PERIOD_EVENT;
                dates[1] = day + date.substring(10, 16); // dd/mm/yyyy hh:mm
                dates[2] = day + date.substring(18); // dd/mm/yyyy HH:MM

            // dd/mm/yyyy hh:mm - DD/MM/YYYY HH:MM
            } else {
                dates = new String[3];
                dates[0] = Event.PERIOD_EVENT;
                dates[1] = date.substring(0, 16); // dd/mm/yyyy hh:mm
                dates[2] = date.substring(19); // DD/MM/YYYY HH:MM
            }
        }
        return dates;
    }
}