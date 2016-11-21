import java.io.FileWriter;
import java.util.ArrayList;

class CsvFileWriter {

    //Delimiter used in CSV file
    private static final char COMMA_DELIMITER = ',';
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "id,Title,Description,Date";

    static void writeCsvFile() {
        String fileName = System.getProperty("user.home") + System.getProperty("file.separator") + "events.csv";
        FileWriter fileWriter = null;

        ArrayList<Event> events = EventList.getEvents();
        try {
            fileWriter = new FileWriter(fileName);
            //Write the CSV file header
            fileWriter.append(FILE_HEADER);
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
            //Write a new event object list to the CSV file
            for (Event event : events) {
                fileWriter.append(String.valueOf(event.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(event.getTitle());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(event.getDescription());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(event.getDate());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully!");
        } catch (Exception e) {
            System.out.println("Can't write events in file!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Error while flushing/closing FileWriter!");
                e.printStackTrace();
            }
        }
    }
}