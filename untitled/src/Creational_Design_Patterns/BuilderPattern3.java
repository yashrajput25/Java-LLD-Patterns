package Creational_Design_Patterns;

class Meal{

    private String mainDish;
    private int size;
    //optional
    boolean cheese, pepperoni, extraSauce;
    String drink, sideOrder;

    private Meal(MealBuilder builder){
            mainDish = builder.mainDish;
            size = builder.size;
            cheese = builder.cheese;
            pepperoni = builder.pepperoni;
            extraSauce = builder.extraSauce;
            drink = builder.drink;
            sideOrder = builder.sideOrder;
    }

    @Override
    public String toString() {
        return "Meal {" +
                "\n  Main Dish   = " + mainDish +
                "\n  Size        = " + size +
                "\n  Cheese      = " + cheese +
                "\n  Pepperoni   = " + pepperoni +
                "\n  Extra Sauce = " + extraSauce +
                "\n  Drink       = " + drink +
                "\n  Side Order  = " + sideOrder +
                "\n}";
    }

    public static class MealBuilder{

        private String mainDish;
        private int size;
        //optional
        boolean cheese, pepperoni, extraSauce;
        String drink, sideOrder;

        public MealBuilder(String mainDish, int size){
            this.mainDish = mainDish;
            this.size = size;
        }

        public MealBuilder setCheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public MealBuilder setPepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        public MealBuilder setExtraSauce(boolean extraSauce) {
            this.extraSauce = extraSauce;
            return this;
        }

        public MealBuilder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public MealBuilder setSideOrder(String sideOrder) {
            this.sideOrder = sideOrder;
            return this;
        }

        public Meal build(){
            return new Meal(this);
        }
    }

}

public class BuilderPattern3 {
    public static void main(String[] args) {

        Meal pizzaMeal = new Meal.MealBuilder("Pizza", 12)
                .setCheese(true)
                .setPepperoni(true)
                .setExtraSauce(true)
                .setDrink("Coke")
                .setSideOrder("Garlic Bread")
                .build();

        Meal burgerMeal = new Meal.MealBuilder("Burger", 8)
                .setDrink("Pepsi")
                .build();

        System.out.println(pizzaMeal);
        System.out.println(burgerMeal);
    }
}
