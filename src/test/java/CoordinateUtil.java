public class CoordinateUtil {

    public String[] split(String input) {
        return split(input, "-");
    }

    public Point convert(String input) {
        String[] coordinate = preprocess(input);
        return new Point(coordinate[0], coordinate[1]);
    }

    private String[] preprocess(String input) {
        return split(input.replaceAll("[()]", ""),",");
    }

    private String[] split(String target, String regex) {
        return target.split(regex);
    }
}
