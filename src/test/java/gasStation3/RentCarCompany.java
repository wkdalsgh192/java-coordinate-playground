package gasStation3;

import java.util.ArrayList;
import java.util.List;

public class RentCarCompany<T extends Car> {

    List<T> cars;

    public static RentCarCompany create() {
        RentCarCompany company = new RentCarCompany();
        company.cars = new ArrayList();
        return company;
    }

    public void addCar(T car) {
        cars.add(car);
    }

    public int getPropertySize() { return cars.size(); }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName()+": "+car.getFuelLevel()+"\n");
        }
        return sb.toString();
    }
}
