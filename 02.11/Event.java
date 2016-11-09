import java.text.SimpleDateFormat;
import java.util.Calendar;

class Event {
    static final String DAY_EVENT = "dd/MM/yyyy";
    static final String PERIOD_EVENT = "dd/MM/yyyy HH:mm";

    private static int idCounter = 1;
    private String dateFormat = "dd/MM/yyyy";
    private String title;
    private String description;
    private Calendar startDate;
    private Calendar finishDate;
    private int id;

    Event(String title, String description, Calendar startDate) {
        if (!title.isEmpty()) this.title = title;
        if (!description.isEmpty()) this.description = description;
        this.startDate = startDate;
        dateFormat = DAY_EVENT;
        id = idCounter;
        idCounter++;
    }

    Event(String title, String description, Calendar startDate, Calendar finishDate) {
        this(title, description, startDate);

        this.finishDate = finishDate;
        dateFormat = PERIOD_EVENT;
    }

    //check event for the presence of timeframes
    boolean hasPeriod() {
        return finishDate != null;
    }

    Calendar getStartDate() {
        return startDate;
    }

    Calendar getFinishDate() {
        return finishDate;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    void setFinishDate(Calendar finishDate) {
        this.finishDate = finishDate;
    }


    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String date = formatter.format(startDate.getTime());
        //Format result like dd/mm/yyyy hh:mm - hh:mm
        if (hasPeriod()) {
            SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
            date += " - " + timeFormatter.format(finishDate.getTime());
            return String.format("%7d %40s %50s %30s", id, title, description, date);
        }
        return String.format("%7d %40s %50s %16s", id, title, description, date);
    }
}
