package gasStation3;

public class Sonata implements Car {

    private double distance;

    public Sonata(double distance) {
        this.distance = distance;
    }

    @Override
    public double getMileage() {
        return 10;
    }

    @Override
    public double getDistance() {
        return distance;
    }
}
