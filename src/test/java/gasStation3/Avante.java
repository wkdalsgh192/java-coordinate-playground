package gasStation3;

public class Avante implements Car {

    private double distance;

    public Avante(double distance) {
        this.distance = distance;
    }

    @Override
    public double getMileage() {
        return 15;
    }

    @Override
    public double getDistance() {
        return distance;
    }
}
