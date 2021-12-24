package gasStation2;

public class Sonata extends Car {

    private double distance;

    public Sonata(double distance) {
        this.distance = distance;
    }

    @Override
    double getGasMileage() {
        return 10;
    }

    @Override
    double getDistance() {
        return distance;
    }
}
