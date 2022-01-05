package coordinate;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CoordinateCalculatorTest {

    @Test
    @DisplayName("좌표 하나가 주어졌을 때 Point 객체로 변환한다.")
    void convert_GivenCoordinate_Expect_ToPoint() {
        Assertions.assertThat(new Point(1,2)).isInstanceOf(Point.class);
    }

    @ParameterizedTest
    @DisplayName("각 좌표의 값 범위는 0 미만이거나 24를 초과할 수 없다.")
    @CsvSource({"-1,1","1,-1","0,25","25,0"})
    void validate_GivenCoordinate_WhenXOrYValueOutOfBounds_Throw_IllegalArgumentException(int x, int y) {
        Assertions.assertThatThrownBy(() -> new Point(x,y)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("직선 좌표인 경우, 두 점 사이의 거리를 계산한다.")
    void calc_GivenTwoCoordinates_WhenValid_Expect_getDistance() {
        Point a = new Point(10,10);
        Point b = new Point(14,15);
        Line line = new Line(a,b);
        Assertions.assertThat(line.calc()).isCloseTo(6.403, Offset.offset(0.001));
    }

    private class Line {

        Point a;
        Point b;

        public Line(Point a, Point b) {
            this.a = a;
            this.b = b;
        }

        public long calc() {
            return 0;
        }
    }
}
