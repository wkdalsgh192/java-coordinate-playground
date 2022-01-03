import java.util.List;

class Segment implements Shape {

    private Point A;
    private Point B;

    public Segment(List<Point> points) {
        validate(points);
        A = points.get(0);
        B = points.get(1);
    }

    double multiply(Segment o) {
        return this.calc()*o.calc();
    }

    int compare(Segment o) {
        return Double.compare(this.calc(), o.calc());
    }

    @Override
    public double calc() {
        return Math.sqrt(Math.pow(A.getX()-B.getX(), 2)+Math.pow(A.getY()-B.getY(),2));
    }

    @Override
    public void validate(List<Point> points) {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        if (p1.equals(p2)) throw new IllegalStateException("두 점이 동일한 경우 선분이 될 수 없습니다.");
    }
}
