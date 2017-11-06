package course1.may10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class MyLineNumberReader extends BufferedReader {
    private int lineNumber;
    private int markedLineNumber;

    private boolean isNewLine;
    private boolean markedSkipLine;

    public MyLineNumberReader(Reader in) {
        super(in);
    }

    public MyLineNumberReader(Reader in, int size) {
        super(in, size);
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int read() throws IOException {
        int c = super.read();
        if (isNewLine) {
            if (c == '\n') {
                c = super.read();
            }
            isNewLine = false;
        }

        switch (c) {
            case '\r':
                isNewLine = true;
            case '\n':
                lineNumber++;
                return '\n';
        }
        return c;
    }

    public int read(char arr[], int start, int len) throws IOException {
        int n = super.read(arr, start, len);

        for (int i = start; i < start + n; i++) {
            int c = arr[i];
            if (isNewLine) {
                isNewLine = false;
                if (c == '\n')
                    continue;
            }
            switch (c) {
                case '\r':
                    isNewLine = true;
                case '\n':
                    lineNumber++;
                    break;
            }
        }

        return n;
    }

    public String readLine() throws IOException {
        String line = super.readLine();
        isNewLine = false;

        if (line != null) lineNumber++;
        return line;
    }

    public long skip(long count) throws IOException {
        if (count < 0) {
            throw new IllegalArgumentException("Value is negative");
        }

        char skipBuffer[] = new char[(int) count];

        long length = count;
        while (length > 0) {
            int nc = read(skipBuffer, 0, (int) length);
            if (nc == -1) break;
            length -= nc;
        }
        return count - length;
    }

    public void mark(int readAheadLimit) throws IOException {
        super.mark(readAheadLimit);
        markedLineNumber = lineNumber;
        markedSkipLine = isNewLine;
    }

    public void reset() throws IOException {
        super.reset();
        lineNumber = markedLineNumber;
        isNewLine = markedSkipLine;
    }
}