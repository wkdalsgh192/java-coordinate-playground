package gasStation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @DisplayName("차량 별로 이동거리가 주어질 때 필요한 연료량을 파악할 수 있는 보고서 내용을 확인한다.")
    @ValueSource(ints = {1950})
    void checkReport_GivenCertainDistance(int distance) {

        RentCarCompany company = RentCarCompany.checkFuel(distance);
        String report = company.writeReport();
        String expected = "gasStation.Sonata: 195L\ngasStation.Avante: 130L\ngasStation.K5: 150L";
        Assertions.assertThat(report.equals(expected)).isTrue();


    }


}
