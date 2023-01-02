package structural.decorator;

// Step 3: Create the abstract decorator class
abstract class PizzaDecorator implements Pizza {
   protected Pizza pizza;

   public PizzaDecorator(Pizza pizza) {
      this.pizza = pizza;
   }

   @Override
   public String getDescription() {
      return pizza.getDescription();
   }

   @Override
   public double getCost() {
      return pizza.getCost();
   }
}
