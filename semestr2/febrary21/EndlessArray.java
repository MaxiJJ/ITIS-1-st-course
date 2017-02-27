package febrary21;

/**
 * Created by Максим on 21.02.2017.
 */
public class EndlessArray<T> implements EndlessArrayInterface<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] tArray;
    private int size = 0;

    public EndlessArray() {
        tArray = new Object[DEFAULT_CAPACITY];
    }

    private void checkSize(int size) {
        int oldCapacity = tArray.length;
        if (size >= oldCapacity) {
            int newCapacity = (oldCapacity * 3) / 2 + 1;
            Object[] oldArr = tArray;
            tArray = new Object[newCapacity];
            System.arraycopy(oldArr, 0, tArray, 0, size);
        }
    }

    @Override
    public void add(T obj) {
        checkSize(size + 1);
        tArray[size] = obj;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index >= size) throw new ArrayIndexOutOfBoundsException("index: " + index + ", size: " + size);
        System.arraycopy(tArray, index + 1, tArray, index, size - index - 1);
        size--;
        tArray[size] = null;
    }

    @Override
    public T get(int index) {
        if (index < size) return (T) tArray[index];
        else throw new ArrayIndexOutOfBoundsException("index: " + index + ", size: " + size);
    }
}
