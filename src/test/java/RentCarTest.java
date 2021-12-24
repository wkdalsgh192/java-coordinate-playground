import gasStation.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RentCarTest {

    @Test
    @DisplayName("연료량이 맞는 지 체크한다.")
    void calcFuel_GivenDifferentCars() {
        Car sonata = new Sonata(200);
        Car avante = new Avante(300);
        Car k5 = new K5(260);

        Assertions.assertThat(sonata.getFuelAmount()).isEqualTo(20);
        Assertions.assertThat(avante.getFuelAmount()).isEqualTo(20);
        Assertions.assertThat(k5.getFuelAmount()).isEqualTo(20);
    }

    private class Sonata extends Car {

        public Sonata(int distance) {
            fuelAmount = distance / getGasMileage();
        }

        @Override
        public int getGasMileage() {
            return 10;
        }
    }

    private class Avante extends Car {

        public Avante(int distance) {
            fuelAmount = distance / getGasMileage();
        }

        @Override
        public int getGasMileage() {
            return 15;
        }
    }

    private class K5 extends Car {

        public K5(int distance) {
            fuelAmount = distance / getGasMileage();
        }

        @Override
        public int getGasMileage() {
            return 13;
        }
    }
}
