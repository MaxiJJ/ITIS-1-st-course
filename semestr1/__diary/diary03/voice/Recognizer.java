package course1.__diary.diary03.voice;

import course1.__diary.diary03.exceptions.AudioPlayException;
import course1.__diary.diary03.exceptions.RecognitionSpeechException;
import course1.__diary.diary03.exceptions.TextRecognitionException;
import course1.__diary.diary03.logic.Event;
import course1.__diary.diary03.logic.EventList;

import java.util.ArrayList;

/**
 * Created by Максим on 11.02.2017.
 */
public class Recognizer {

    public static final int READ_ALL = 0;
    public static final int SAVE = 1;

    private static final String[] readAllPhrases = {"читать все", "смотреть все"};

    private static final String[] savePhrases = {"сохранить"};

    private static final String[] sortByTitle = {"сортировать по заголовку", "сортировать по названию"};

    public static int recognize() throws RecognitionSpeechException {
        ArrayList<String> speech = Controller.recognize();
        System.out.println(speech.toString());

        for (String s : speech) {

            String string = s.toLowerCase();

            //TODO: use regular expression
            for (String readAll : readAllPhrases) {
                if (string.contains(readAll)) return READ_ALL;

            }

            for (String save : savePhrases) {
                if (string.contains(save)) return SAVE;

            }


            //TODO: readEvent
            //Прочитать событие номер X
            //http://www.sql.ru/forum/212697/preobrazovanie-iz-chislo-v-chislo-propisu
        }
        throw new RecognitionSpeechException("Can't recognize command");
    }


    public static void readAll() throws AudioPlayException, TextRecognitionException {
        ArrayList<Event> events = EventList.getInstance().getEvents();
        System.out.println(events.toString());

        int num = 1;
        String text;
        for (Event event : events) {
            text = String.format("Событие номер %d, Название события %s, Описание события %s, Дата события %s", num, event.getTitle(), event.getDescription(), event.getDate());
            System.out.println(text);
            Controller.play(text);

            num++;
        }
    }

}
