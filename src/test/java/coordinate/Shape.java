package coordinate;

import java.util.List;

public interface Shape {

    void validate(List<Point> points);

    double calc();
    double applyFormula();
}
