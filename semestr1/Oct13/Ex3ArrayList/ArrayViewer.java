public class ArrayViewer {
    public static void main(String[] args) {
        PointArrayList ar = new PointArrayList();
        for (int i = 0; i < 100; i++) {
            Point p = new Point(i,i);
            ar.add(p);
            System.out.println(ar.get(i).getXY());
        }

        for (int i = 0; i < 100; i++) {
            int count = i / 5;
            if (i % 5 != 0) {
                ar.remove(1 + count);
            }
            else {
                System.out.println(ar.get(count).getXY());
            }
        }
    }
}
