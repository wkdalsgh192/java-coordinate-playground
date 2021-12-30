class Square extends Shape {

    private Line w;
    private Line h;

    protected Square(String[] input) {
        super(input);
        this.w = Line.of(points.get(0), points.get(1));
        this.h = Line.of(points.get(0), points.get(2));
    }

    @Override
    double calc() {
        return w.calc()*h.calc();
    }
}
