
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

abstract class Shape {

    protected List<Point> points;

    protected Shape() {}

    protected Shape(String[] input) {
        this.points = Arrays.stream(input)
                .map(CoordinateUtil::convert)
                .sorted((p1, p2) -> {
                    if (p1.getX() == p2.getX()) return p1.getY() - p2.getY();
                    return p1.getX() - p2.getX();
                })
                .collect(Collectors.toList());
    }

    abstract double calc();
}
