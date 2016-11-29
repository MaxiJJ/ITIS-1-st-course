import java.util.Scanner;

class PointViewer {
    public static void main(String[] args) {
        Point point = new Point();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your prefered input method:\n" +
                "Enter \"false\" to get point from file.\n" +
                "Enter \"true\" to get point from console.");
        boolean choose = sc.nextBoolean();
        if (choose) 
        point.getPointConsole();
        else point.getPointFile();
        System.out.print("Distance is " + DistanceCalculator.getDistance(point));
    }
}
