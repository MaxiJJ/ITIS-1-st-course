package course1.__diary.diary01;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Event {
    public static final String DAY_EVENT = "dd/MM/yyyy";
    public static final String PERIOD_EVENT = "dd/MM/yyyy HH:mm";

    private static int idCounter = 1;
    private String dateFormat = "dd/MM/yyyy";

    private String description;
    private String date;
    private int id;
    private String title;
    private Calendar startDate;
    private Calendar finishDate;

    public Event(String title, String description, Calendar startDate) {
        if (!title.isEmpty()) this.title = title;
        if (!description.isEmpty()) this.description = description;
        this.startDate = startDate;
        dateFormat = DAY_EVENT;
        id = idCounter;
        idCounter++;
        date = getFormattedDate();
    }

    public Event(String title, String description, Calendar startDate, Calendar finishDate) {
        this(title, description, startDate);
        this.finishDate = finishDate;
        dateFormat = PERIOD_EVENT;
        date = getFormattedDate();
    }

    //check event for the presence of timeframes
    public boolean hasPeriod() {
        return finishDate != null;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getFinishDate() {
        return finishDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(Calendar finishDate) {
        this.finishDate = finishDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setIdCounter(int idCounter) {
        Event.idCounter = idCounter;
    }

    /**
     * Format date in correct format for printing.
     *
     * @return result like dd/mm/yyyy hh:mm - hh:mm if day same.
     *         Else dd/mm/yyyy hh:mm - dd/mm/yyyy hh:mm
     */
    private String getFormattedDate() {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String date = formatter.format(startDate.getTime());

        if (hasPeriod()) {
            String finish = formatter.format(finishDate.getTime());
            if (date.substring(0, 10).equals(finish.substring(0, 10))) {
                date += " - " + finish.substring(11);
            } else {
                date += " - " + finish;
            }
        }
        return date;
    }

    @Override
    public String toString() {
        if (hasPeriod()) {
            //check date format is "dd/mm/yyyy hh:mm - hh:mm" or not.
            if (date.length() < 30) {
                return String.format("%7d %40s %50s %34s", id, title, description, date);
            }
            return String.format("%7d %40s %50s %45s", id, title, description, date);
        }
        return String.format("%7d %40s %50s %20s", id, title, description, date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (!dateFormat.equals(event.dateFormat)) return false;
        if (!title.equals(event.title)) return false;
        if (!description.equals(event.description)) return false;
        if (!startDate.equals(event.startDate)) return false;
        return finishDate != null ? finishDate.equals(event.finishDate) : event.finishDate == null;
    }

    @Override
    public int hashCode() {
        int result = dateFormat.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + (finishDate != null ? finishDate.hashCode() : 0);
        return result;
    }
}