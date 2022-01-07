package coordinate.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Rectangle extends AbstractShape {

    public Rectangle(List<Point> points) {
        super(points);
    }

    public Rectangle() {}

    public void validate(List<Point> points) {
        Set<Integer> valueSetX = new HashSet<>();
        Set<Integer> valueSetY = new HashSet<>();
        points.forEach(p -> {
            valueSetX.add(p.getX());
            valueSetY.add(p.getY());
        });
        if (valueSetX.size() != 2 && valueSetY.size() != 2) throw new IllegalArgumentException("직사각형이 아닙니다.");
    }

    private List<Point> sort(List<Point> points) {
        return points.stream().sorted((p1, p2) -> {
            if (p1.getX() == p2.getX()) return p1.getY() - p2.getY();
            return p1.getX() - p2.getX();
        }).collect(Collectors.toList());
    }

    public double applyFormula() {
        Point p1 = points.get(0);
        Point p2 = points.get(3);

        long width = Math.abs(p1.getX() - p2.getX());
        long height = Math.abs(p1.getY() - p2.getY());
        return width * height;
    }
}
