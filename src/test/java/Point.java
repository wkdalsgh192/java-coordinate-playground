import java.util.Objects;

public class Point {

    private final int MINIMUM = 0;
    private final int MAXIMUM = 24;
    private int x;
    private int y;

    public Point(String x, String y) {
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
        validate(this.x, this.y);
    }

    private void validate(int x, int y) {
        if (x < MINIMUM || x > MAXIMUM || y < MINIMUM || y > MAXIMUM)
            throw new IllegalArgumentException("각 좌표의 값 범위는 24를 초과하지 않는 양수여야 합니다.");
    }

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
