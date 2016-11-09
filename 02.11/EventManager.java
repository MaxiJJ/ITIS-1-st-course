import java.text.*;
import java.util.*;

class EventManager {
    private final static String SWITCH_MENU = "_______________________________________________\n\n";
    private Scanner sc = new Scanner(System.in);

    void start() {
        System.out.println("-----------------------------------------");
        System.out.println("|             EVENT MANAGER             |");
        System.out.println("-----------------------------------------");

        String option;
        do {
            System.out.println("Choose one of the following options:\n");
            System.out.println("1. EVENT TABLE");
            System.out.println("2. ADD EVENT");
            System.out.println("3. EDIT EVENT");
            System.out.println("4. EXIT APP");

            option = sc.nextLine().toUpperCase();
            if (option.isEmpty()) option = sc.nextLine().toUpperCase();

            switch (option) {
                case "1":
                case "EVENT TABLE":
                case "EVENT":
                case "ET": {
                    System.out.println(SWITCH_MENU);
                    showEvents();
                    break;
                }

                case "2":
                case "ADD":
                case "ADD EVENT":
                case "AE": {
                    System.out.println(SWITCH_MENU);
                    addEvent();
                    break;
                }

                case "3":
                case "EDIT":
                case "EDIT EVENT": {
                    System.out.println(SWITCH_MENU);
                    editEvent();
                    break;
                }

                case "4":
                case "EX":
                case "EXIT": {
                    System.out.println(SWITCH_MENU);
                    System.exit(0);
                    break;
                }
            }
        } while (true);
    }

    private void showEvents() {
        String option;
        do {
            System.out.println("What do you want to see?\n");
            System.out.println("1. ALL EVENTS");
            System.out.println("2. EVENTS FOR CERTAIN DAY");
            System.out.println("3. EVENTS FOR PERIOD");
            System.out.println("4. BACK\n");

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
            System.out.println("What type of events you want to add?\n");
            System.out.println("1. ADD ORDINARY EVENT");
            System.out.println("2. ADD AN EVENT FOR A PERIOD");
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
                default: continue;
            }

            do {
                System.out.println("\n\nChoose one of the following options:\n");
                System.out.println("1. ADD ONE MORE EVENT");
                System.out.println("2. BACK");
                option = sc.nextLine().toUpperCase();

                if (option.equals("1") || option.equals("ADD ONE MORE EVENT") || option.equals("ADD EVENT") ||
                        option.equals("ADD")) {
                    System.out.println();
                    System.out.println(SWITCH_MENU);
                    break;
                } else if ((option.equals("2") || option.equals("BACK") || option.equals("B"))) {
                    isCompeted = true;
                }
            } while (!isCompeted);
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
            System.out.println("What do you want to change\n");
            System.out.println("1. TITLE");
            System.out.println("2. DESCRIPTION");
            System.out.println("3. DATE");
            System.out.println("4. ALL");
            System.out.println("5. BACK\n");

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
            System.out.printf("%7s %40s %50s %30s", "id", "Title", "Description", "Date");
            System.out.println();
            System.out.println(events);
        }
        System.out.println("\n\n");

        String option;
        do {
            System.out.println("Choose one of the following options:\n");
            System.out.println("1. BACK");

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
                System.out.println("The end date can't be earlier than the event start date.");
                System.out.println("Please enter right dates!\n");
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