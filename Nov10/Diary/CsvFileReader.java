import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

class CsvFileReader {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    //Event attributes index
    private static final int EVENT_TITLE = 1;
    private static final int EVENT_DESCRIPTION = 2;
    private static final int EVENT_DATE = 3;

    static void readCsvFile() {
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
                    //Create a new event object and fill his  data
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
            System.out.println("Error in CsvFileReader !");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !");
                e.printStackTrace();
            }
        }
    }

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
            startDate = dates[0];
            dateFormat = dates[1];
        }

        if (dates.length == 3) {
            startDate = dates[0];
            endDate = dates[1];
            dateFormat = dates[2];

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

    //return date(s) and date format
    private static String[] processDate(String date) {
        int length = date.length();
        String[] dates = null;
        if (length > 0) {
            // dd/mm/yyyy
            if (length < 20) {
                dates = new String[2];
                dates[0] = date;
                dates[1] = Event.DAY_EVENT;
                // dd/mm/yyyy hh:mm - hh:mm
            } else if (length < 30) {
                dates = new String[3];
                String day = date.substring(0, 10);
                dates[0] = day + date.substring(10, 16);
                dates[1] = day + date.substring(18);
                dates[2] = Event.PERIOD_EVENT;
                //dd/mm/yyyy hh:mm - dd/mm/yyyy hh:mm
            } else {
                dates = new String[3];
                dates[0] = date.substring(0, 16);
                dates[1] = date.substring(19);
                dates[2] = Event.PERIOD_EVENT;
            }
        }
        return dates;
    }
}