package coordinateSystem;

import java.util.ArrayList;
import java.util.List;

public class CoordinateCalculator {

    List<Coordinate> coordinates;

    public CoordinateCalculator(String input) {
        coordinates = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            makeCoordinate(input, i);
        }
    }

    private void makeCoordinate(String input, int startIdx) {
        if (input.charAt(startIdx) != '(') return;
        coordinates.add(Coordinate.from(extract(input, startIdx)));
    }

    private String[] extract(String input, int idx) {
        int end = idx;
        while (input.charAt(end) !=')') ++end;
        return input.substring(idx+1, end).split(",");
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
