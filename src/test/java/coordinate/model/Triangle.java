package coordinate.model;

import java.util.List;

class Triangle extends AbstractShape {


    public Triangle(List<Point> points) {
        super(points);
    }

    public Triangle() {}

    @Override
    public void validate(List<Point> points) {
        // TODO 장민호 모두 다른 점일때만 가능하다
    }

    public double applyFormula() {
        Line a = new Line(List.of(points.get(0), points.get(1)));
        Line b = new Line(List.of(points.get(0), points.get(2)));
        Line c = new Line(List.of(points.get(1), points.get(2)));

        double s = (a.calc() + b.calc() + c.calc()) / 2;
        return Math.sqrt(s * (s - a.calc()) * (s - b.calc()) * (s - c.calc()));
    }
}
