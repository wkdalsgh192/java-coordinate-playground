package gasStation3;

public interface Car {

    double getMileage();

    double getDistance();

    default String getName() {
        return this.getClass().getSimpleName();
    }

    default double getFuelLevel() {
        return getDistance() / getMileage();
    }
}
