package coordinate.model;

import java.util.List;
import java.util.Objects;

public abstract class AbstractShape implements Shape {
    static final String ERROR_FIGURE_NULL = "올바른 Point 값이 아닙니다.";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractShape that = (AbstractShape) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
