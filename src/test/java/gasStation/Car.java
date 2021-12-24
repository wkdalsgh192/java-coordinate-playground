package gasStation;

public abstract class Car {

    public int fuelAmount;

    protected abstract int getGasMileage();

    public String report() {
        return this.getClass().getName()+": "+fuelAmount+"L";
    }

    public int getFuelAmount() {
        return fuelAmount;
    }
}
