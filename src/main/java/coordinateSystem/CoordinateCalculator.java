package coordinateSystem;

import java.util.ArrayList;
import java.util.List;

public class CoordinateCalculator {

    List<Coordinate> coordinates;

    public CoordinateCalculator(String input) {
        coordinates = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            makeCoordinate(input, i, input.charAt(i) == '(');
        }
    }

    // TODO [장민호] 파라미터 갯수를 줄이려면 어떻게 해야할까?
    private void makeCoordinate(String input, int start, boolean matched) {
        if (!matched) return;
        int end = start;
        while (input.charAt(end) !=')') ++end;
        coordinates.add(new Coordinate(input.substring(start + 1, end)));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Coordinate coordinate : coordinates) sb.append(coordinate+"-");
        return sb.substring(0, sb.length()-1);
    }

    public double getLineLength() {
        Coordinate A = coordinates.get(0);
        Coordinate B = coordinates.get(1);
        return Math.sqrt(Math.pow(A.getX() - B.getX(), 2) + Math.pow(A.getY() - B.getY(), 2));
    }
}
