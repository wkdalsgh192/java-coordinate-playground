public abstract class CaffeineBeverage {
    abstract void boil();

    abstract void addCondiments();

    protected void pourInCup() {
        System.out.println("컵에 붓는다.");
    }
}
