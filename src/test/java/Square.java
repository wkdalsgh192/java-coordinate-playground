import java.util.List;

class Square extends Shape {

    private Line w;
    private Line h;

    protected Square(String[] input) {
        super(input);
        validate(points);
        this.w = Line.of(points.get(0), points.get(1));
        this.h = Line.of(points.get(0), points.get(2));
    }

    private void validate(List<Point> points) {
        Line w1 = Line.of(points.get(0), points.get(1));
        Line w2 = Line.of(points.get(2), points.get(3));
        Line h1 = Line.of(points.get(0), points.get(2));
        Line h2 = Line.of(points.get(1), points.get(3));

        if (w1.compare(w2) != 0 || h1.compare(h2) != 0)
            throw new IllegalStateException("직사각형이 아닙니다.");
    }

    @Override
    double calc() {
        return w.multiply(h);
    }
}
