package course1.april6;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Created by Максим on 13.04.2017.
 */
public class FileFormatIdentidier {
    private final static byte[] GIF_BYTES = {71, 73, 70, 56, 57, 97};
    private final static byte[] JPEG_BYTES = {-1, -40, -1, -32, 0, 16, 74, 70};
    private final static byte[] PNG_BYTES = {-119, 80, 78, 71, 13, 10, 26, 10};
    private final static byte[] BMP_BYTES = {66, 77};

    public static String getType(Path path) throws IOException {
        byte[] bytes = getFileBytes(path);

        if (isBMP(bytes)) {
            return "BMP";
        } else if (isGIF(bytes)) {
            return "GIF";
        } else if (isJPEG(bytes)) {
            return "JPEG";
        } else if (isPNG(bytes)) {
            return "PNG";
        }
        return "Unknown format";
    }

    private static byte[] getFileBytes(Path path) throws FileNotFoundException {
        File file = new File(path.toUri());

        if (!file.isFile()) {
            throw new FileNotFoundException("Isn't file");
        }

        byte[] arr = new byte[8];

        try (InputStream iS = new FileInputStream(file)) {
            iS.read(arr, 0, 8);
            iS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public static boolean isGIF(byte[] bytes) throws IOException {
        final int byteCount = 6;
        return isType(bytes, GIF_BYTES, byteCount);
    }

    public static boolean isJPEG(byte[] bytes) throws IOException {
        final int byteCount = 8;
        return isType(bytes, JPEG_BYTES, byteCount);
    }

    public static boolean isPNG(byte[] bytes) throws IOException {
        final int byteCount = 8;
        return isType(bytes, PNG_BYTES, byteCount);
    }

    public static boolean isBMP(byte[] bytes) throws IOException {
        final int byteCount = 2;
        return isType(bytes, BMP_BYTES, byteCount);
    }

    private static boolean isType(byte[] bytes, byte[] typeBytes, int byteCount) {
        return Arrays.equals(typeBytes, Arrays.copyOf(bytes, byteCount));
    }
}
