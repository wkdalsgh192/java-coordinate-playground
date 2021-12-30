import org.assertj.core.util.Arrays;

import java.util.List;

abstract class Shape {
    protected List<Point> points;

    protected Shape(String[] input) {
    }
    abstract double calc();
}
