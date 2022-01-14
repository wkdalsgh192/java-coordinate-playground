package coordinate.view;

import coordinate.model.Point;
import coordinate.model.Shape;
import coordinate.model.ShapeFactory;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InputView {

    private static final String INITIAL_NOTICE_TEXT = "좌표를 입력하세요.\n";

    public static Shape insert() {
        System.out.println(INITIAL_NOTICE_TEXT);
        return insert(new Scanner(System.in).nextLine());
    }

    public static Shape insert(String s) {
        try {
            validate(s);
            Points points = parsePoint(s);
            return ShapeFactory.create(points.get());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return insert();
        }
    }

    public static void validate(String s) {
        final String regex = "(\\([0-9]{1,2},[0-9]{1,2}\\))(-(\\([0-9]{1,2},[0-9]{1,2}\\))){0,3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (!matcher.matches()) throw new IllegalArgumentException();
    }

    public static Points parsePoint(String input) {
        String[] coordinates = input.split("-");
        Points points = Points.create();
        for (String coordinate : coordinates) {
            points.add(makePoint(coordinate));
        }
        return points;
    }

    public static Point makePoint(String s) {
        Pattern pattern = Pattern.compile("\\(([0-9]{1,2}),([0-9]{1,2})\\)");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            String x = matcher.group(1);
            String y = matcher.group(2);
            return new Point(Integer.parseInt(x), Integer.parseInt(y));
        }
        throw new IllegalArgumentException();
    }
}
