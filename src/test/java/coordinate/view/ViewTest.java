package coordinate.view;

import coordinate.model.Line;
import coordinate.model.Shape;
import coordinate.model.ShapeFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import coordinate.model.Point;
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
            List<Point> points = parse(s);
            return ShapeFactory.create(points);
        }

        private static List<Point> parse(String s) {
            String[] coordinates = s.replaceAll("[()]","").split("-");
            List<Point> points = new ArrayList<>();
            for (String coordinate : coordinates) {
                String[] xy = coordinate.split(",");
                points.add(new Point(Integer.parseInt(xy[0]),Integer.parseInt(xy[1])));
            }
            return points;
        }

        public static void validate(String s) {
            Pattern pattern = Pattern.compile("(\\d\\d,\\d\\d)+[-]*");
            Matcher matcher = pattern.matcher(s);
            if (!matcher.matches()) throw new IllegalArgumentException();
        }
    }
}
