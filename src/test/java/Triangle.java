import java.util.Arrays;
import java.util.List;

public class Triangle implements Shape {

    private Line a;
    private Line b;
    private Line c;

    public Triangle(List<Point> points) {
        validate(points);
        a = new Line(Arrays.asList(points.get(0), points.get(1)));
        b = new Line(Arrays.asList(points.get(1), points.get(2)));
        c = new Line(Arrays.asList(points.get(2), points.get(0)));
    }

    private void validate(List<Point> points) {
        Point A = points.get(0);
        Point B = points.get(1);
        Point C = points.get(2);
        if (A.getX() == B.getX() && B.getX() == C.getX()) throw new IllegalStateException("삼각형의 기본 조건을 만족하지 않습니다.");
        if (A.getY() == B.getY() && B.getY() == C.getY()) throw new IllegalStateException("삼각형의 기본 조건을 만족하지 않습니다.");
    }

    @Override
    public double calc() {
        double s = (a.calc()+b.calc()+c.calc())/2;
        return Math.sqrt(s*(s-a.calc())*(s-b.calc())*(s-c.calc()));
    }
}
