package coordinate;

import java.util.List;

public abstract class AbstractShape implements Shape {
    final List<Point> points;

    AbstractShape(List<Point> points) {
        validate(points);
        this.points = points;
    }

    public abstract void validate(List<Point> points);

    public double calc() {
        return applyFormula();
    }

    public abstract double applyFormula();


}
