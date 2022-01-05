package coordinate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.offset;

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

    @Nested
    @DisplayName("")
    class LineTest {

        List<Point> points;

        @BeforeEach
        void init() {
            points = Arrays.asList(new Point(10,10),new Point(14,15));
        }

        @Test
        @DisplayName("직선 좌표인 경우, 두 점 사이의 거리를 계산한다.")
        void calc_GivenTwoCoordinates_WhenValid_Expect_getDistance() {
            Line line = new Line(points);
            Assertions.assertThat(line.calc()).isEqualTo(6.4031242374328485);
        }
    }

    @Nested
    @DisplayName("")
    class RectangleTest {

        List<Point> points;

        @BeforeEach
        void init() {
            points = Arrays.asList(new Point(10,10),new Point(22,10),new Point(22,18),new Point(10,18));
        }

        @Test
        @DisplayName("사각형 좌표인 경우, 네 점이 이루는 사각형이 직사각형이여야 한다. ")
        void validate_GivenFourCoordinates_WhenValid_Expect_ToRectangle() {
            Rectangle r = new Rectangle(points);
            Assertions.assertThat(r).isInstanceOf(Rectangle.class);
        }
    }

    private class Rectangle {

        List<Point> points;

        public Rectangle(List<Point> points) {
            validate(points);
            this.points = points;
        }

        private void validate(List<Point> points) {
            Set<Integer> valueSetX = new HashSet<>();
            Set<Integer> valueSetY = new HashSet<>();
            points.forEach(p -> {
                valueSetX.add(p.getX());
                valueSetY.add(p.getY());
            });
            if (valueSetX.size() != 2 && valueSetY.size() != 2) throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }
}
