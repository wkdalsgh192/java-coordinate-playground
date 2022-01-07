package coordinate.model;

import java.util.List;

class Line extends AbstractShape {

    public Line(List<Point> points) {
        super(points);
    }

    public Line() {
        super();
    }

    @Override
    public void validate(List<Point> points) {
    }

    public double calc() {
        return applyFormula();
    }

     public double applyFormula() {
        Point a = points.get(0);
        Point b = points.get(1);
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
}
