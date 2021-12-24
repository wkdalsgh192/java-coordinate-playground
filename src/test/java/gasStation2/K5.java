package gasStation2;

public class K5 extends Car{

    private double distance;

    public K5(double distance) {
        this.distance = distance;
    }

    @Override
    double getGasMileage() {
        return 13;
    }

    @Override
    double getDistance() {
        return distance;
    }
}
