import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coordinate {

    public static Shape getShapeFrom(String[] input) {
        List<Point> points = extractPoints(input);
        switch (points.size()) {
            case 3:
                return new Triangle(points);
            case 4:
                return new Square(points);
            default:
                return new Segment(points);
        }
    }

    private static List<Point> extractPoints(String[] input) {
        return Arrays.stream(input)
                .map(CoordinateUtil::convert)
                .sorted((p1, p2) -> {
                    if (p1.getX() == p2.getX()) return p1.getY() - p2.getY();
                    return p1.getX() - p2.getX();
                })
                .collect(Collectors.toList());
    }
}
