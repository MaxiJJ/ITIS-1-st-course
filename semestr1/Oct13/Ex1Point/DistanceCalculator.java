class DistanceCalculator {

    private DistanceCalculator() {}

    static double getDistance(Point point) {
        double deltaX = (point.getX1() - point.getX());
        double deltaY = (point.getY1() - point.getY());
        return Math.sqrt(deltaX*deltaX+deltaY*deltaY);
    }
}
