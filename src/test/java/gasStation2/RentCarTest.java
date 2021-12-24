package gasStation2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RentCarTest {
    private static final String NEWLINE = System.getProperty("line.separator");

    @Test
    @DisplayName("여러 자동차들이 주어질 때 회사가 소유한 차량 댓수를 확인한다.")
    void addCar_GivenFiveDifferentCars_Expect_SizeEqualsFive() {
        RentCarCompany company = RentCarCompany.create();
        company.addCar(new Avante(300));
        company.addCar(new Sonata(100));
        company.addCar(new K5(260));
        company.addCar(new Sonata(200));
        company.addCar(new K5(390));

        Assertions.assertThat(company.getPropertySize()).isEqualTo(5);
    }

    @Test
    @DisplayName("회사가 여러 자동차들을 소유할 때 필요한 연료량을 확인할 수 있는 보고서를 생성한다.")
    void generateReport_GivenCompanyOwnsCars_Expect_ReportShowsTheirNameAndFuelLevel() {
        RentCarCompany company = RentCarCompany.create();
        company.addCar(new Avante(300));
        company.addCar(new Sonata(100));
        company.addCar(new K5(260));
        company.addCar(new Sonata(200));
        company.addCar(new K5(390));

        Assertions.assertThat(company.generateReport()).isEqualTo(
                "Avante: 20.0\nSonata: 10.0\nK5: 20.0\nSonata: 20.0\nK5: 30.0\n"
        );
    }
}
