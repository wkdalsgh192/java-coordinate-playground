package gasStation3;

public class K5 implements Car {

    private double distance;

    public K5(double distance) {
        this.distance = distance;
    }

    @Override
    public double getMileage() {
        return 13;
    }

    @Override
    public double getDistance() {
        return distance;
    }
}
