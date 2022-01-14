package coordinate.view;

import coordinate.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ViewTest {

    @Test
    @DisplayName("사용자가 입력한 좌표 정보 형태가 잘 못된 경우, 다시 입력을 받는다.")
    void whenUserPutsInvalidCoordinates_Expect_RequireDifferentInput() {
        Assertions.assertThatThrownBy(() -> InputView.validate("(10,10)*(10,12)")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 정상 좌표값을 입력한 경우, 좌표 리스트로 변환한다.")
    void whenUserPutsValidCoordinates_Expect_ToPointList() {
        Points points = InputView.parsePoint("(10,10)-(10,12)");
        Assertions.assertThat(points.contains(new Point(10,10))).isTrue();
        Assertions.assertThat(points.contains(new Point(10,12))).isTrue();
    }

    @Test
    @DisplayName("사용자가 정상 좌표값을 입력한 경우, 형태 검증 후 그에 알맞는 도형을 반환한다")
    void whenUserPutsValidCoordinates_Expect_Validate_And_CreateShape() {
        Assertions.assertThat(InputView.insert("(10,10)-(10,12)")).isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("사용자가 2개의 좌표를 입력한 경우, 선분을 반환한다.")
    void whenUserPutsTwoCoordinates_Expect_CreateLine() {
        Shape shape = InputView.insert("(10,12)-(15,20)");
        Points points = Points.create();
        points.add(new Point(10,12));
        points.add(new Point(15,20));
        Assertions.assertThat(shape).isEqualTo(ShapeFactory.create(points.get())).isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("사용자가 3개의 좌표를 입력한 경우, 삼각형을 반환한다.")
    void whenUserPutsValidCoordinates_Expect_CreateTriangle() {
        Shape shape = InputView.insert("(10,10)-(10,12)-(8,5)");
        Points pointList = Points.create();
        pointList.add(new Point(10,10));
        pointList.add(new Point(10,12));
        pointList.add(new Point(8,5));
        Assertions.assertThat(shape).isEqualTo(ShapeFactory.create(pointList.get())).isInstanceOf(Triangle.class);
    }

    @Test
    @DisplayName("사용자가 4개의 좌표를 입력한 경우, 사각형을 반환한다.")
    void whenUserPutsFourCoordinates_Expect_CreateRectangle() {
        Shape shape = InputView.insert("(10,10)-(10,12)-(15,10)-(15,12)");
        Points points = Points.create();
        points.add(new Point(10,10));
        points.add(new Point(10,12));
        points.add(new Point(15,10));
        points.add(new Point(15,12));
        Assertions.assertThat(shape).isEqualTo(ShapeFactory.create(points.get())).isInstanceOf(Rectangle.class);
    }
}
