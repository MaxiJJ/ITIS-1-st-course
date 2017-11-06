//package course1.__diary.diary01.utils;
//
//import course1.__diary.diary01.course1.Event;
//import course1.__diary.diary01.EventList;
//
//import java.io.FileWriter;
//import java.util.ArrayList;
//
//public class CsvFileWriter {
//
//    //Delimiter used in CSV file
//    private static final char COMMA_DELIMITER = ',';
//    private static final String NEW_LINE_SEPARATOR = "\n";
//
//    public static void writeCsvFile() {
//        String fileName = System.getProperty("user.home") + System.getProperty("file.separator") + "events.csv";
//        FileWriter fileWriter = null;
//
//        try {
//            fileWriter = new FileWriter(fileName);
//            //Add a new line separator after the header
//            fileWriter.append(NEW_LINE_SEPARATOR);
//            //Write a new event object list to the CSV file
//            for (course1.Event event : events) {
//                fileWriter.append(String.valueOf(event.getId()));
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(event.getTitle());
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(event.getDescription());
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(event.getDate());
//                fileWriter.append(NEW_LINE_SEPARATOR);
//            }
//            System.out.println("CSV file was created successfully!");
//        } catch (Exception e) {
//            System.out.println("Can't write events in file!");
//            e.printStackTrace();
//        } finally {
//            try {
//                fileWriter.flush();
//                fileWriter.close();
//            } catch (Exception e) {
//                System.out.println("Error while flushing/closing FileWriter!");
//                e.printStackTrace();
//            }
//        }
//    }
//}