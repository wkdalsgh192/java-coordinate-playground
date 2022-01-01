import java.util.List;

class Line implements Shape {

    List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    double multiply(Line o) {
        return this.calc()*o.calc();
    }

    int compare(Line o) {
        return Double.compare(this.calc(), o.calc());
    }

    @Override
    public double calc() {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        return Math.sqrt(Math.pow(p1.getX()-p2.getX(), 2)+Math.pow(p1.getY()-p2.getY(),2));
    }
}
