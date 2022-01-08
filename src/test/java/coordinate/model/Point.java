package coordinate.model;

import java.util.Objects;

public class Point {

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
        if (v < MINIMUM_VALUE_BOUND || v > MAXIMUM_VALUE_BOUND) throw new IllegalArgumentException();
        return v;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
