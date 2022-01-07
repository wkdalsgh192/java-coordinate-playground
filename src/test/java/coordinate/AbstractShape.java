package coordinate;

import java.util.List;

public abstract class AbstractShape implements Shape {
    List<Point> points;

    AbstractShape(List<Point> points) {
        this.points = points;
    }

    AbstractShape() {}

    public abstract void validate(List<Point> points);

    public double calc() {
        return applyFormula();
    }

    public abstract double applyFormula();


}
