package behavioral.visitor;

// Concrete room part
class Bedroom implements Room {

   @Override
   public void accept(Visitor visitor) {
      visitor.visit(this);
   }

   public void turnOffLight() {
      System.out.println("Turn off the Light");
   }
}
