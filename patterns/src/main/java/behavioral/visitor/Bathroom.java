package behavioral.visitor;

// Concrete room part
class Bathroom implements Room {

   @Override
   public void accept(Visitor visitor) {
      visitor.visit(this);
   }

   public void turnOnLight() {
      System.out.println("Turn on the Light");
   }
}
