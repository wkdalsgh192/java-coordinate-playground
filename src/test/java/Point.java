public class Point {

    private final int MINIMUM = 0;
    private final int MAXIMUM = 24;
    private int x;
    private int y;

    public Point(int x, int y) {
        if (x < MINIMUM || x > MAXIMUM || y < MINIMUM || y > MAXIMUM) throw new IllegalArgumentException("각 좌표의 값 범위는 24를 초과하지 않는 양수여야 합니다.");
        this.x = x;
        this.y = y;
    }
}
