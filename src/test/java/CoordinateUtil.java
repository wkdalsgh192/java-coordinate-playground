public class CoordinateUtil {

    public static String[] split(String input) {
        return split(input, "-");
    }

    public static Point convert(String input) {
        String[] coordinate = preprocess(input);
        return new Point(coordinate[0], coordinate[1]);
    }

    private static String[] preprocess(String input) {
        return split(input.replaceAll("[()]", ""),",");
    }

    private static String[] split(String target, String regex) {
        return target.split(regex);
    }
}
