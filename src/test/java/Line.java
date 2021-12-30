class Line extends Shape {

    Line(String[] points) { super(points); }

    @Override
    double calc() {
        Point p1 = points.remove(0);
        Point p2 = points.remove(0);
        return Math.sqrt(Math.pow(p1.getX()-p2.getX(), 2)+Math.pow(p1.getY()-p2.getY(),2));
    }
}
