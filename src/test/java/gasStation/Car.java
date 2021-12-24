package gasStation;

public abstract class Car {

    public int fuelAmount;

    protected abstract int getGasMileage();

    public int getFuelAmount() {
        return fuelAmount;
    }
}
