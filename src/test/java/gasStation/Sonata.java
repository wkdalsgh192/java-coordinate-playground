package gasStation;

import gasStation.Car;

class Sonata extends Car {

    public Sonata(int distance) {
        fuelAmount = distance / getGasMileage();
    }

    @Override
    public int getGasMileage() {
        return 10;
    }
}
