import lombok.Value;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CoordinateCalculatorTest {

    @Test
    @DisplayName("각 좌표의 값 범위는 음수가 될 수 없다.")
    void validateCoordinate_GivenNegativeNumber_Throw_IllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Point(-1,20))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("각 좌표의 값 범위는 24를 초과하지 않는 양수여야 합니다.");
    }

    @Test
    @DisplayName("각 좌표의 값 범위는 24를 초과할 수 없다")
    void validateCoordinate_GivenNumberOverTwentyFour_Throw_IllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> new Point(25,20))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("각 좌표의 값 범위는 24를 초과하지 않는 양수여야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("좌표를 입력했을 때, 주어진 좌표의 갯수를 확인하고, Shape 클래스로 캐스팅한다.")
    @ValueSource(strings = {"(10,10)-(10,12)", "(10,10)-(22,10)-(22,18)-(10,18)"})
    void insertCoordinate_Expect_CountPoints_And_CheckShape(String input) {
        Assertions.assertThat(Coordinate.getShapeFrom(CoordinateUtil.split(input))).isInstanceOf(Shape.class);
    }

    @Test
    @DisplayName("2 개의 좌표가 주어지면, 선으로 분류한다.")
    void insertCoordinate_WhenTwoPointsGiven_Expect_CreateLine() {
        Assertions.assertThat(Coordinate.getShapeFrom(CoordinateUtil.split("(10,10)-(10,12)"))).isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("4 개의 좌표가 주어지면, 사각형으로 분류한다.")
    void insertCoordinate_WhenTwoPointsGiven_Expect_CreateSquare() {
        Assertions.assertThat(Coordinate.getShapeFrom(CoordinateUtil.split("(10,10)-(22,10)-(22,18)-(10,18)"))).isInstanceOf(Square.class);
    }
}
