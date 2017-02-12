package november3.diary;

import november3.diary.utils.CsvFileReader;
import november3.diary.utils.CsvFileWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class EventManager {
    private final static String SWITCH_MENU = "_______________________________________________\n\n";
    private final Scanner sc = new Scanner(System.in);

    public void start() {
        printHelloMessage();
        performStartMenu();
    }

    private void printHelloMessage() {
        System.out.println("●▬▬▬▬▬▬▬▬▬▬๑۩۩๑▬▬▬▬▬▬▬▬▬▬●\n" +
                "▌             EVENT MANAGER             ▌\n" +
                "●▬▬▬▬▬▬▬▬▬▬▬๑▬▬▬▬▬▬▬▬▬▬▬●\n");
    }

    private void performStartMenu() {
        String option;
        do {
            System.out.println("Choose one of the following options:\n" +
                    "1. EVENT TABLE\n" +
                    "2. ADD EVENT\n" +
                    "3. EDIT EVENT\n" +
                    "4. SAVE EVENTS TO FILE\n" +
                    "5. READ EVENTS FROM FILE\n" +
                    "6. EXIT APP\n");

            option = sc.nextLine().toUpperCase();
            if (option.isEmpty()) option = sc.nextLine().toUpperCase();

            System.out.println(SWITCH_MENU);
            switch (option) {
                case "1":
                case "EVENT TABLE":
                case "EVENT":
                case "ET": {
                    showEvents();
                    break;
                }

                case "2":
                case "ADD EVENT":
                case "ADD":
                case "AE": {
                    addEvent();
                    break;
                }

                case "3":
                case "EDIT EVENT":
                case "EDIT": {
                    editEvent();
                    break;
                }

                case "4":
                case "SAVE EVENTS TO FILE":
                case "SAVE TO FILE":
                case "SAVE EVENTS":
                case "SAVE FILE":
                case "SAVE":
                case "SF": {
                    CsvFileWriter.writeCsvFile();
                    System.out.println(SWITCH_MENU);
                    break;
                }

                case "5":
                case "READ EVENTS FROM FILE":
                case "READ FROM FILE":
                case "READ EVENTS":
                case "READ FILE":
                case "READ":
                case "RF": {
                    CsvFileReader.readCsvFile();
                    System.out.println(SWITCH_MENU);
                    break;
                }

                case "6":
                case "EXIT":
                case "EX": {
                    System.exit(0);
                    break;
                }
            }
        } while (true);
    }

    private void showEvents() {
        String option;
        do {
            System.out.println("What do you want to see?\n" +
                    "1. ALL EVENTS\n" +
                    "2. EVENTS FOR CERTAIN DAY\n" +
                    "3. EVENTS FOR PERIOD\n" +
                    "4. BACK\n\n");

            option = sc.nextLine().toUpperCase();
            if (option.isEmpty()) option = sc.nextLine().toUpperCase();

            System.out.println(SWITCH_MENU);
            switch (option) {
                case "1":
                case "ALL EVENTS":
                case "ALL":
                case "AE": {
                    String events = EventList.getAllEvents();
                    showTable(events);
                    break;
                }

                case "2":
                case "EVENTS FOR CERTAIN DAY":
                case "EVENT FOR DAY":
                case "EVENT DAY":
                case "DAY":
                case "ED": {
                    String events = EventList.getDayEvents(scanOrdinaryDate());
                    showTable(events);
                    break;
                }

                case "3":
                case "EVENTS FOR PERIOD":
                case "EVENTS PERIOD":
                case "PERIOD":
                case "EP": {
                    Calendar[] dates = scanDatePeriod();
                    String events = EventList.getEventsForPeriod(dates[0], dates[1]);
                    showTable(events);
                    break;
                }
            }
        } while (!(option.equals("4") || option.equals("BACK") || option.equals("B")));
    }

    private void addEvent() {
        boolean isCompeted = false;
        String option;
        do {
            System.out.println("What type of events you want to add?\n" +
                    "1. ADD ORDINARY EVENT\n" +
                    "2. ADD AN EVENT FOR A PERIOD\n" +
                    "3. BACK\n\n");
            option = sc.nextLine().toUpperCase();
            if (option.isEmpty()) option = sc.nextLine().toUpperCase();

            System.out.println(SWITCH_MENU);
            switch (option) {
                case "1":
                case "ADD ORDINARY EVENT":
                case "ORDINARY EVENT":
                case "AOE":
                case "OE": {
                    addEvent(true);
                    break;
                }
                case "2":
                case "ADD AN EVENT FOR A PERIOD":
                case "ADD EVENT FOR A PERIOD":
                case "ADD EVENT FOR PERIOD":
                case "ADD EVENT PERIOD":
                case "AEP":
                case "EP": {
                    addEvent(false);
                    break;
                }
                case "BACK":
                case "B":
                case "3": {
                    isCompeted = true;
                }
                default:
                    continue;
            }

            do {
                System.out.println("\n\nChoose one of the following options:\n" +
                        "1. ADD ONE MORE EVENT\n" +
                        "2. BACK\n");
                option = sc.nextLine().toUpperCase();

                if (option.equals("1") || option.equals("ADD ONE MORE EVENT") || option.equals("ADD EVENT") ||
                        option.equals("ADD")) {
                    System.out.println();
                    System.out.println(SWITCH_MENU);
                    break;
                } else {
                    isCompeted = true;
                }
            } while (!(option.equals("2") || option.equals("BACK") || option.equals("B")));
        } while (!isCompeted);
        System.out.println(SWITCH_MENU);
    }

    private void editEvent() {
        System.out.println(EventList.getAllEvents());
        System.out.println();
        int id = scanId();
        System.out.println();
        String option;
        do {
            System.out.println(EventList.getEvent(id));
            System.out.println();
            System.out.println("What do you want to change\n" +
                    "1. TITLE\n" +
                    "2. DESCRIPTION\n" +
                    "3. DATE\n" +
                    "4. ALL\n" +
                    "5. BACK\n\n");

            option = sc.nextLine().toUpperCase();
            if (option.isEmpty()) option = sc.nextLine().toUpperCase();

            switch (option) {
                case "1":
                case "TITLE":
                case "T": {
                    System.out.println("Please, enter title of event:");
                    String title = sc.nextLine();
                    EventList.editEvent(id, title, "", null);
                    break;
                }
                case "2":
                case "DESCRIPTION":
                case "DESC":
                case "DES": {
                    System.out.println("Please, enter description of event:");
                    String description = sc.nextLine();
                    EventList.editEvent(id, "", description, null);
                    break;
                }
                case "3":
                case "DATE":
                case "DAT": {
                    if (EventList.getEvent(id).hasPeriod()) {
                        Calendar[] dates = scanDatePeriod();
                        EventList.editEvent(id, "", "", dates[0], dates[1]);
                    } else {
                        EventList.editEvent(id, "", "", scanOrdinaryDate());
                    }
                    break;
                }
                case "4":
                case "ALL": {
                    System.out.println("Please, enter title of event:");
                    String title = sc.nextLine();
                    System.out.println("Please, enter description of event:");
                    String description = sc.nextLine();
                    if (EventList.getEvent(id).hasPeriod()) {
                        Calendar[] dates = scanDatePeriod();
                        EventList.editEvent(id, title, description, dates[0], dates[1]);
                    } else {
                        EventList.editEvent(id, title, description, scanOrdinaryDate());
                    }
                    break;
                }
            }

        } while (!(option.equals("5") || option.equals("BACK") || option.equals("B")));
        System.out.println(SWITCH_MENU);
    }

    private void showTable(String events) {
        if (events.isEmpty()) {
            System.out.println("There are no events");
        } else {
            System.out.printf("%7s %40s %50s %45s", "id", "Title", "Description", "Date");
            System.out.println();
            System.out.println(events);
        }
        System.out.println("\n\n");

        String option;
        do {
            System.out.println("Choose one of the following options:\n" +
                    "1. BACK\n");

            option = sc.next().toUpperCase();
        } while (!(option.equals("1") || option.equals("BACK") || option.equals("B")));

        System.out.println(SWITCH_MENU);
    }

    private void addEvent(boolean isOrdinaryEvent) {
        System.out.println("Please enter title of event:");
        String title = sc.nextLine();
        System.out.println("Please enter description of event:");
        String description = sc.nextLine();

        if (isOrdinaryEvent) {
            EventList.addEvent(new Event(title, description, scanOrdinaryDate()));
        } else {
            Calendar[] dates = scanDatePeriod();
            EventList.addEvent(new Event(title, description, dates[0], dates[1]));
        }
        System.out.println("Event successfully added!\n\n");
    }

    // scan 2 date in format dd/mm/yyyy hh:mm
    private Calendar[] scanDatePeriod() {
        boolean isRightDates = false;
        Calendar start = null;
        Calendar finish = null;
        while (!isRightDates) {
            System.out.println("Please enter the event start date in the format \"" + Event.PERIOD_EVENT.toLowerCase() + "\" :");
            start = scanDate(Event.PERIOD_EVENT);
            System.out.println("Please enter the event end date in the format \"" + Event.PERIOD_EVENT.toLowerCase() + "\" :");
            finish = scanDate(Event.PERIOD_EVENT);
            if (start.before(finish) || start.equals(finish)) {
                isRightDates = true;
            } else {
                System.out.println("The end date can't be earlier than the event start date.\n" +
                        "Please enter right dates!\n\n");
            }
        }

        return new Calendar[]{start, finish};
    }

    // scan date in format dd/mm/yyyy
    private Calendar scanOrdinaryDate() {
        System.out.println("Please enter the event date in the format \"" + Event.DAY_EVENT.toLowerCase() + "\" :");
        return scanDate(Event.DAY_EVENT);
    }

    // scan in a specified date format
    private Calendar scanDate(String dateFormat) {
        String date = sc.nextLine();

        Calendar c = Calendar.getInstance();
        c.setLenient(false);
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        format.setLenient(false);

        boolean isRightData = false;
        while (!isRightData) {
            try {
                c.setTime(format.parse(date));
                isRightData = true;
            } catch (ParseException e) {
                System.out.println("Please enter right date!");
                date = sc.nextLine();
            }
        }
        return c;
    }

    private int scanId() {
        System.out.println("Please, enter id of event:");
        int id = sc.nextInt();

        while (id > EventList.getSize()) {
            System.out.println("Please, enter right id!");
            id = sc.nextInt();
        }
        return id;
    }
}