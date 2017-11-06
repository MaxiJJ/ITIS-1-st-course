package course1.__diary.diary03.exceptions;

public class RecognitionSpeechException extends Exception {

    public RecognitionSpeechException() {
    }

    public RecognitionSpeechException(String message) {
        super(message);
    }

    public RecognitionSpeechException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecognitionSpeechException(Throwable cause) {
        super(cause);
    }
}
