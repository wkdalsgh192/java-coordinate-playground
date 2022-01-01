import java.util.Arrays;

class Line extends Shape {

    Line() {}

    Line(String[] points) { super(points); }

    static Line of(Point p1, Point p2) {
        Line line = new Line();
        line.points = Arrays.asList(p1,p2);
        return line;
    }

    @Override
    double calc() {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        return Math.sqrt(Math.pow(p1.getX()-p2.getX(), 2)+Math.pow(p1.getY()-p2.getY(),2));
    }
}
