package coordinate;

import java.util.List;

class Line {

    List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public double calc() {
        return applyFormula();
    }

    private double applyFormula() {
        Point a = points.get(0);
        Point b = points.get(1);
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
}
