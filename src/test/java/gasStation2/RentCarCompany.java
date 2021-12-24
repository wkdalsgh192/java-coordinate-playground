package gasStation2;

import java.util.LinkedList;
import java.util.List;

public class RentCarCompany<T extends Car> {

    private List<T> cars;

    public static RentCarCompany create() {
        RentCarCompany company = new RentCarCompany();
        company.cars = new LinkedList();
        return company;
    }

    public void addCar(T car) {
        this.cars.add(car);
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
