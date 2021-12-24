package gasStation2;

public class Avante extends Car{

    private double distance;

    public Avante(double distance) {
        this.distance = distance;
    }

    @Override
    double getGasMileage() {
        return 15;
    }

    @Override
    double getDistance() {
        return distance;
    }
}
