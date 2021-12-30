import lombok.Value;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CoordinateCalculatorTest {

    private CoordinateUtil util = new CoordinateUtil();

    @Test
    @DisplayName("좌표 하나가 주어졌을 때 Point 객체로 변환한다.")
    void convert_GivenCoordinateString_Expect_Point() {
        Assertions.assertThat(util.convert("(10,12)")).isEqualTo(new Point("10","12"));
    }

    @Test
    @DisplayName("각 좌표의 값 범위는 음수가 될 수 없다.")
    void validateCoordinate_GivenNegativeNumber_Throw_IllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Point("-1","20"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("각 좌표의 값 범위는 24를 초과하지 않는 양수여야 합니다.");
    }

    @Test
    @DisplayName("각 좌표의 값 범위는 24를 초과할 수 없다")
    void validateCoordinate_GivenNumberOverTwentyFour_Throw_IllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Point("25","20"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("각 좌표의 값 범위는 24를 초과하지 않는 양수여야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("좌표를 입력했을 때, 주어진 좌표의 갯수를 확인하고, Shape 클래스로 캐스팅한다.")
    @ValueSource(strings = {"(10,10)-(10,12)", "(10,10)-(22,10)-(22,18)-(10,18)"})
    void insertCoordinate_Expect_CountPoints_And_CheckShape(String input) {
        Assertions.assertThat(Coordinate.getShapeFrom(util.split(input))).isInstanceOf(Shape.class);
    }

    @Test
    @DisplayName("2개의 좌표가 주어지면, 선으로 분류한다.")
    void insertCoordinate_WhenTwoPointsGiven_Expect_CreateLine() {
        Assertions.assertThat(Coordinate.getShapeFrom(util.split("(10,10)-(10,12)"))).isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("4개의 좌표가 주어지면, 사각형으로 분류한다.")
    void insertCoordinate_WhenTwoPointsGiven_Expect_CreateSquare() {
        Assertions.assertThat(Coordinate.getShapeFrom(util.split("(10,10)-(22,10)-(22,18)-(10,18)"))).isInstanceOf(Square.class);
    }

    @Test
    @DisplayName("직선 좌표인 경우, 두 점 사이의 거리를 계산한다.")
    void calc_WhenTwoPointsGiven_Expect_LengthOfLine() {
        String input = "(10,10)-(10,12)";
        Shape shape = Coordinate.getShapeFrom(util.split(input));
        Assertions.assertThat(shape.calc()).isEqualTo(6.403124, Offset.offset(0.0001));
    }
}
