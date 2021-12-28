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
}
