import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Maxim Kuznetsov
 * @version 1.0
 */
public class MyString {
    /**
     * The value is used for character storage.
     */
    private char[] charSequence;

    /**
     * Initializes a newly created object so that it represents
     * an empty character sequence.
     */
    MyString() {
        charSequence = new char[0];
    }

    /**
     * Initializes a newly created object so that it represents the sequence of
     * characters currently contained in the character array argument.
     *
     * @param charSequence The initial char sequences of the string
     */
    MyString(char[] charSequence) {
        this.charSequence = charSequence;
    }

    /**
     * Initializes a newly created object so that it represents the characters
     * sequence of String argument.
     *
     * @param line
     * The initial value of the {@link java.lang.String String}.
     */
    MyString(String line) {
        charSequence = line.toCharArray();
    }

    /**
     * Initializes a newly created object so that it represents
     * the same sequence of characters as the argument.
     * @param line A MyString
     */
    MyString(MyString line) {
        charSequence = line.toCharArray();
    }

    /**
     * Concatenates the specified string to the end of this string.
     *
     * @param str the MyString that is concatenated to the end
     *                of this MyString.
     * @return a string that represents the concatenation of this object's
     *          characters followed by the string argument's characters.
     */
    MyString concat(MyString str) {
        int otherLen = str.length();
        if (otherLen == 0) {
            return this;
        }
        int len = charSequence.length;
        char buf[] = Arrays.copyOf(charSequence, len + otherLen);
        System.arraycopy(str.charSequence, 0, buf, len, otherLen);
        return new MyString(buf);
    }

    /**
     * Converts this string to a new character array.
     *
     * @return a new character array whose length is the length
     *          of this string and whose contents are initialized to contain
     *          the character sequence represented by this string.
     */
    char[] toCharArray() {
        return charSequence;
    }

    /**
     * Returns the char value at the
     * specified index.
     *
     * @param index the index of the char value.
     * @return     the char value at the specified index of this string.
     * @exception  StringIndexOutOfBoundsException  if index
     *             argument is negative or larger than the length of this
     *             string.
     */
    char charAt(int index) {
        if ((index < 0) || (index >= charSequence.length)) {
            throw new StringIndexOutOfBoundsException(index);
        }
        return charSequence[index];
    }

    /**
     * Returns the index within this string of the first occurrence of the
     * specified substring.
     *
     * @param line the substring to search for.
     * @return the index of the first occurrence of the specified substring,
     *          or -1 if there is no such occurrence.
     */
    int indexOf(MyString line) {
        int len = charSequence.length;
        int k = 0;

        for (int i = 0; i < len; i++) {
            if (charSequence[i] != line.charSequence[0]) continue;
            for (int j = 0; j < line.charSequence.length; j++) {
                if (i + j < len && charSequence[i + j] == line.charSequence[j]) k++;
                else break;
            }
            if (k == line.charSequence.length) return i;
            else k = 0;
        }
        return -1;
    }

    /**
     * Returns a string that is a substring of this string.
     *
     * @param beginIndex the beginning index.
     * @param length the length.
     * @return the specified substring.
     * @exception  StringIndexOutOfBoundsException  if the
     *             beginIndex is negative, or
     *             sum of beginIndex and length is larger than the length of
     *             this MyString object, or
     *             length is negative.
     */
    MyString substring(int beginIndex, int length) {
        if (beginIndex < 0) {
            throw new StringIndexOutOfBoundsException(beginIndex);
        }
        if (length + beginIndex > charSequence.length) {
            throw new StringIndexOutOfBoundsException(beginIndex + length);
        }
        if (length < 0) {
            throw new StringIndexOutOfBoundsException(length);
        }
        if ((beginIndex == 0) && (length + beginIndex == charSequence.length)) {
            return this;
        }
        char result[] = new char[length];
        System.arraycopy(charSequence, beginIndex, result, 0, length);
        return new MyString(result);
    }

    /**
     * Returns the length of this string.
     * The length is equal to the number of
     * characters in the string.
     *
     * @return  the length of the sequence of characters represented by this
     *          object.
     */
    int length() {
        return charSequence.length;
    }

    /**
     * Splits this string around matches of
     * the given character.
     *
     * @param delimiter the delimiting character.
     * @return the array of strings computed by splitting this string
     *          around matches of the given character.
     */
    MyString[] split(char delimiter) {
        ArrayList<MyString> list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < charSequence.length; i++) {
            if (charSequence[i] == delimiter) {
                if (start != i) {
                    list.add(substring(start, i - start));
                }
                start = i + 1;
            } else if (i == charSequence.length - 1) {
                list.add(substring(start, i - start + 1));
            }
        }
        MyString[] splitted = new MyString[list.size()];
        return list.toArray(splitted);
    }

    @Override
    public String toString() {
        return new String(charSequence);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyString myString = (MyString) o;

        return Arrays.equals(charSequence, myString.charSequence);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(charSequence);
    }
}
//Run from .java file directory
// javadoc -private -use -author -version -d C:\Users\Максим\IdeaProjects\doc MyString.java