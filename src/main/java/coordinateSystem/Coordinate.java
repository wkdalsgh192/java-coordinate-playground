package coordinateSystem;

public class Coordinate {

    private final static int INPUT_CONSTRAINT = 24;
    private int x;
    private int y;

    public static Coordinate from(String[] input) {
        Coordinate coordinate = new Coordinate();
        coordinate.x = Integer.parseInt(input[0]);
        coordinate.y = Integer.parseInt(input[1]);

        if (coordinate.x > INPUT_CONSTRAINT || coordinate.y > INPUT_CONSTRAINT) throw new IllegalArgumentException("입력값은 24를 초과할 수 없습니다.");
        return coordinate;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
