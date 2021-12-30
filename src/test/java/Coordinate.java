public class Coordinate {

    public static Shape getShapeFrom(String[] points) {
        if (points.length == 2) return new Line(points);
        return new Square(points);
    }
}
