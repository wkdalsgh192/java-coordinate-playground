import java.util.Arrays;
import java.util.List;

class Square implements Shape {

    private Line w;
    private Line h;

    public Square(List<Point> points) {
        validate(points);
        w = new Line(Arrays.asList(points.get(0), points.get(1)));
        h = new Line(Arrays.asList(points.get(0), points.get(2)));
    }

    private void validate(List<Point> points) {
        Line w1 = new Line(Arrays.asList(points.get(0), points.get(1)));
        Line w2 = new Line(Arrays.asList(points.get(2), points.get(3)));
        Line h1 = new Line(Arrays.asList(points.get(0), points.get(2)));
        Line h2 = new Line(Arrays.asList(points.get(1), points.get(3)));

        if (w1.compare(w2) != 0 || h1.compare(h2) != 0)
            throw new IllegalStateException("직사각형이 아닙니다.");
    }

    @Override
    public double calc() {
        return w.multiply(h);
    }
}
