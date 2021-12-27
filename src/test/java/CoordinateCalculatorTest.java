import coordinateSystem.CoordinateCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CoordinateCalculatorTest {
    @ParameterizedTest
    @DisplayName("좌표를 두 개 입력했을 때 두 좌표 사이에 '-' 문자가 들어가야 한다.")
    @ValueSource(strings = {"(1,2)(3,4)"})
    void insertCoordinate_GivenTwoCoordinates_Expect_DashAddedBetweenThem(String input) {
        CoordinateCalculator calculator = new CoordinateCalculator(input);
        Assertions.assertThat(calculator.toString()).isEqualTo("(1,2)-(3,4)");
    }

    @ParameterizedTest
    @DisplayName("좌표를 입력했을 때 24를 초과하면 에러 문구를 출력한다.")
    @ValueSource(strings = {"(25,25)", "(1,25)", "(25,0)"})
    void insertCoordinate_GivenCoordinateOver24_Throw_IllegalArgumentException(String input) {
        Assertions.assertThatThrownBy(() -> new CoordinateCalculator(input)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력값은 24를 초과할 수 없습니다.");

    }
}
