public class Coffee extends CaffeineBeverage {
    void prepareRecipe() {
        boil();
        brewCoffeeGrinds();
        pourInCup();
        addCondiments();
    }

    private void brewCoffeeGrinds() {
        System.out.println("필터를 활용해 커피를 내린다.");
    }

    @Override
    void boil() {
        System.out.println("필터를 활용해 커피를 내린다.");
    }

    @Override
    void addCondiments() {
        System.out.println("설탕과 우유를 추가한다.");
    }

    public static void main(String[] args) {
        CaffeineBeverage beverage = new Coffee(); // 업케스팅 - 커피 인스턴스를 생성해놓고 상위 클래스인 카페인음료라고 하는 것 == 커피는 카페인 음료디.

        if (beverage instanceof Coffee) {
            Coffee coffee = (Coffee) beverage; // 다운캐스팅 - 생성된 카페인음료를 커피하고 하는 것.
            coffee.prepareRecipe();
        }
    }
}