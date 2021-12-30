
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

abstract class Shape {
    protected List<Point> points;

    protected Shape(String[] input) {
        this.points = Arrays.stream(input).map(CoordinateUtil::convert).collect(Collectors.toList());
    }
    abstract double calc();
}
