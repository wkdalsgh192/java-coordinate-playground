package coordinate;

class Point {

    private final int MINIMUM_VALUE_BOUND = 0;
    private final int MAXIMUM_VALUE_BOUND = 24;
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = validateBounds(x);
        this.y = validateBounds(y);
    }

    // NOTE: 검증 로직은 INPUT VIEW에서?
    private int validateBounds(int v) {
        if (v < MINIMUM_VALUE_BOUND || y > MAXIMUM_VALUE_BOUND) throw new IllegalArgumentException();
        return v;
    }

    public int getX() { return x; }

    public int getY() { return y; }
}
