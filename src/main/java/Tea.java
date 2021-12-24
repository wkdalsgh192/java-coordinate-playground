public class Tea extends CaffeineBeverage {
    void prepareRecipe() {
        boil();
        steepTeaBag();
        pourInCup();
        addCondiments();
    }

    private void steepTeaBag() {
        System.out.println("티백을 담근다.");
    }

    @Override
    void boil() {
        System.out.println("필터를 담근다.");
    }

    @Override
    void addCondiments() {
        System.out.println("레몬을 추가한다.");
    }
}
