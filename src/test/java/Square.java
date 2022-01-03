import java.util.Arrays;
import java.util.List;

class Square implements Shape {

    private Segment w;
    private Segment h;

    public Square(List<Point> points) {
        validate(points);
        w = new Segment(Arrays.asList(points.get(0), points.get(1)));
        h = new Segment(Arrays.asList(points.get(0), points.get(2)));
    }

    @Override
    public double calc() {
        return w.multiply(h);
    }

    @Override
    public void validate(List<Point> points) {
        Segment w1 = new Segment(Arrays.asList(points.get(0), points.get(1)));
        Segment w2 = new Segment(Arrays.asList(points.get(2), points.get(3)));
        Segment h1 = new Segment(Arrays.asList(points.get(0), points.get(2)));
        Segment h2 = new Segment(Arrays.asList(points.get(1), points.get(3)));

        if (w1.compare(w2) != 0 || h1.compare(h2) != 0)
            throw new IllegalStateException("직사각형이 아닙니다.");
    }
}
