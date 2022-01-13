package coordinate.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ShapeFactory {
    private static final int NUM_OF_VERTICES_OF_LINE = 2;
    private static final int NUM_OF_VERTICES_OF_TRIANGLE = 3;
    private static final int NUM_OF_VERTICES_OF_RECTANGLE = 4;
    private static final Map<Integer, Function<List<Point>, Shape>> classifier = new HashMap<>();

    static {
        classifier.put(NUM_OF_VERTICES_OF_LINE, Line::new);
        classifier.put(NUM_OF_VERTICES_OF_TRIANGLE, Triangle::new);
        classifier.put(NUM_OF_VERTICES_OF_RECTANGLE, Rectangle::new);
    }

    public static Shape create(List<Point> points) {
        if (points == null) throw new IllegalArgumentException(AbstractShape.ERROR_FIGURE_NULL);
        return classifyShape(points);
    }

    public static Shape classifyShape(List<Point> points) {
        return classifier.get(points.size()).apply(points);
    }
}
