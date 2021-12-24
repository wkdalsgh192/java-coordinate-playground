package gasStation;

import gasStation.Car;

class Avante extends Car {

    public Avante(int distance) {
        fuelAmount = distance / getGasMileage();
    }

    @Override
    public int getGasMileage() {
        return 15;
    }
}
