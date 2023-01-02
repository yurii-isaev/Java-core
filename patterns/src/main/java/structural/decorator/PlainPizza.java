package structural.decorator;

// Step 2: Implement the concrete component
class PlainPizza implements Pizza {

   @Override
   public String getDescription() {
      return "Plain pizza";
   }

   @Override
   public double getCost() {
      return 10.0;
   }
}
