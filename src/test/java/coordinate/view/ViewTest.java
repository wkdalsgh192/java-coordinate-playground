package coordinate.view;

import coordinate.model.Line;
import coordinate.model.Point;
import coordinate.model.Shape;
import coordinate.model.ShapeFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewTest {

/*    @Test
    @DisplayName("처음 어플리케이션을 시작하면 '좌표를 입력하세요' 라는 문구를 출력하고, 입력값을 받는다 ")
    void whenApplicationRuns_Expect_PrintOutNotices() {
        Assertions.assertThat(InputView.show()).isEqualTo("좌표를 입력하세요.");
    }*/

    @Test
    @DisplayName("사용자가 입력한 좌표 정보 형태가 잘 못된 경우, 다시 입력을 받는다.")
    void whenUserPutsInvalidCoordinates_Expect_RequireDifferentInput() {
        Assertions.assertThatThrownBy(() -> InputView.validate("(10,10)*(10,12)")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 정상 좌표값을 입력한 경우, 좌표 리스트로 변환한다.")
    void whenUserPutsValidCoordinates_Expect_ToPointList() {
        Points points = InputView.parse("(10,10)-(10,12)");
        Assertions.assertThat(points.contains(new Point(10,10))).isTrue();
        Assertions.assertThat(points.contains(new Point(10,12))).isTrue();
    }

    @Test
    @DisplayName("사용자가 정상 좌표값을 입력한 경우, 형태 검증 후 그에 알맞는 도형을 반환한다")
    void whenUserPutsValidCoordinates_Expect_Validagte_And_CreateShape() {
        Assertions.assertThat(InputView.insert("(10,10)-(10,12)")).isInstanceOf(Line.class);
    }

    private static class InputView {

        private static final String INITIAL_NOTICE_TEXT = "좌표를 입력하세요.\n";

        public static String show() {
            System.out.println(INITIAL_NOTICE_TEXT);
            return new Scanner(System.in).nextLine();
        }

        public static Shape insert(String s) {
            validate(s);
            Points points = parse(s);
            return ShapeFactory.create(points.get());
        }

        public static Points parse(String s) {
            String[] coordinates = s.replaceAll("[()]","").split("-");
            Points points = Points.create();
            for (String coordinate : coordinates) {
                String[] xy = coordinate.split(",");
                points.add(new Point(Integer.parseInt(xy[0]),Integer.parseInt(xy[1])));
            }
            return points;
        }

        public static void validate(String s) {
            final String regex = "(\\([0-9]{1,2},[0-9]{1,2}\\))(-(\\([0-9]{1,2},[0-9]{1,2}\\))){0,3}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(s);
            if (!matcher.matches()) throw new IllegalArgumentException();
        }
    }

    private static class Points {

        private static List<Point> pointList;

        public static Points create() {
            Points points = new Points();
            points.pointList = new ArrayList<>();
            return points;
        }

        boolean contains(Point other) {
            for (Point point : pointList) {
                if (point.equals(other)) return true;
            }
            return false;
        }

        public void add(Point point) {
            pointList.add(point);
        }

        public List<Point> get() { return pointList; }
    }
}
