class PointArrayList {
    private static final int DEFAULT_CAPACITY = 10;
    private Point[] points;
    private static int size = 0;

    PointArrayList() {
        points = new Point[DEFAULT_CAPACITY];
    }

    private void checkSize(int size) {
        int oldCapacity = points.length;
        if (size >= oldCapacity) {
            int newCapacity = (oldCapacity*3)/2 + 1;
            Point[] oldArr = points;
            points = new Point[newCapacity];
            System.arraycopy(oldArr,0,points,0,size);
        }
    }

    void add(Point point) {
        checkSize(size + 1);
        points[size] = point;
        size++;
    }

    void remove(int index) {
        if (index >= size) throw new ArrayIndexOutOfBoundsException("index: " + index + ", size: " + size);
        System.arraycopy(points,index + 1, points, index, size - index - 1);
        size--;
        points[size] = null;
    }

    Point get(int index) {
        if (index < size) return points[index];
        else throw new ArrayIndexOutOfBoundsException("index: " + index + ", size: " + size);
    }
}
