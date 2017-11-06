package course1.__diary.diary03.exceptions;

public class AudioCaptureException extends Exception {

    public AudioCaptureException() {
    }

    public AudioCaptureException(String message) {
        super(message);
    }

    public AudioCaptureException(String message, Throwable cause) {
        super(message, cause);
    }

    public AudioCaptureException(Throwable cause) {
        super(cause);
    }
}
