package coordinate;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;
import java.util.List;

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
    @DisplayName("직선 테스트")
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
    @DisplayName("직사각형 테스트")
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

        @Test
        @DisplayName("직사각형 좌표에인 경우, 사각형의 면적을 계산한다.")
        void calc_GivenFourCoordinates_WhenRectangle_Expect_getArea() {
            Rectangle r = new Rectangle(points);
            Assertions.assertThat(r.calc()).isEqualTo(96, Offset.offset(0.0001));
        }
    }

    @Nested
    @DisplayName("삼각형 테스트")
    class TriangleTest {

        List<Point> points;

        @BeforeEach
        void init() {
            points = Arrays.asList(new Point(10,10),new Point(14,15),new Point(20,8));
        }

        @Test
        @DisplayName("삼각형 좌표인 경우, 삼각형의 면적을 계산한다")
        void calc_GivenThreeCoordinates_WhenTriangle_Expect_GetArea() {
            Triangle t = new Triangle(points);
            Assertions.assertThat(t.calc()).isEqualTo(29, Offset.offset(0.1));
        }

        private class Triangle {

            List<Point> points;

            public Triangle(List<Point> points) {
                this.points = points;
            }

            public double calc() {
                return applyFormula();
            }

            private double applyFormula() {
                Line a = new Line(List.of(points.get(0), points.get(1)));
                Line b = new Line(List.of(points.get(0), points.get(2)));
                Line c = new Line(List.of(points.get(1), points.get(2)));

                double s = (a.calc()+b.calc()+c.calc())/2;
                return Math.sqrt(s*(s-a.calc())*(s-b.calc())*(s-c.calc()));
            }
        }
    }

}
