package gasStation;

import gasStation.Car;

class K5 extends Car {

    public K5(int distance) {
        fuelAmount = distance / getGasMileage();
    }

    @Override
    public int getGasMileage() {
        return 13;
    }
}
