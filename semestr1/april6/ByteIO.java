package course1.april6;

import java.io.*;
import java.nio.file.Path;

/**
 * Created by Максим on 13.04.2017.
 */
public class ByteIO {
    private Path path;

    public ByteIO(Path path) {
        this.path = path;
    }

    public void write(int[] arr) {
        try (OutputStream os = new FileOutputStream(new File(path.toUri()))) {
            os.write(intToByte(arr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] read() {
        try (InputStream is = new FileInputStream(new File(path.toUri()))) {
            byte[] byteArr = new byte[20 << 2];
            is.read(byteArr);
            int[] intArr = byteToInt(byteArr);
            return intArr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] intToByte(int[] src) {
        int srcLength = src.length;
        byte[] dst = new byte[srcLength << 2];

        for (int i = 0; i < srcLength; i++) {
            int x = src[i];
            int j = i << 2;
            dst[j++] = (byte) ((x >>> 0) & 0xff);
            dst[j++] = (byte) ((x >>> 8) & 0xff);
            dst[j++] = (byte) ((x >>> 16) & 0xff);
            dst[j++] = (byte) ((x >>> 24) & 0xff);
        }
        return dst;
    }

    private static int[] byteToInt(byte[] src) {
        int srcLength = src.length;
        int[] dst = new int[srcLength >> 2];

        for (int i = 0; i < dst.length; i++) {
            int j = i * 4;

            dst[i] = ((src[j] << 0) & 0xff)
                    + ((src[j + 1] << 8) & 0xff)
                    + ((src[j + 2] << 16) & 0xff)
                    + ((src[j + 3] << 24) & 0xff);
        }
        return dst;
    }
}
