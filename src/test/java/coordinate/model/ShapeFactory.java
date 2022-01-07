package coordinate.model;

import java.util.List;

public class ShapeFactory {

    public static Shape create(List<Point> points) {
        if (points.size() == 2) return new Line(points);
        if (points.size() == 3) return new Triangle(points);
        if (points.size() == 4) return new Rectangle(points);
        throw new IllegalStateException("해당 좌표 갯수에 알맞는 도형이 없습니다.");
    }
}
