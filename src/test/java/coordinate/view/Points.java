package coordinate.view;

import coordinate.model.Point;

import java.util.ArrayList;
import java.util.List;

class Points {

    private List<Point> pointList;

    public static Points create() {
        Points points = new Points();
        points.pointList = new ArrayList<>();
        return points;
    }

    boolean contains(Point other) {
        for (Point point : pointList) {
            if (point.equals(other)) return true;
        }
        return false;
    }

    public void add(Point point) {
        pointList.add(point);
    }

    public List<Point> get() {
        return pointList;
    }
}
