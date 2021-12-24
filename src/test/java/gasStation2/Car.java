package gasStation2;

public abstract class Car {

    abstract double getGasMileage();

    abstract double getDistance();

    String getName() {
        return this.getClass().getSimpleName();
    };

    double getFuelLevel() {
        return getDistance() / getGasMileage();
    }
}
