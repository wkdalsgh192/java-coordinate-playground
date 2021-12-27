package coordinateSystem;

public class Coordinate {

    private final int INPUT_CONSTRAINT = 24;
    private int x;
    private int y;

    public Coordinate(String input) {
        // input 데이터에 문제가 있을 때에는 어떻게 처리?
        String[] coordinate = input.split(",");
        x = Integer.valueOf(coordinate[0]);
        y = Integer.valueOf(coordinate[1]);

        if (x > INPUT_CONSTRAINT || y > INPUT_CONSTRAINT) throw new IllegalArgumentException("입력값은 24를 초과할 수 없습니다.");
    }

    public int getX() { return x; }

    public int getY() { return y; }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
