package behavioral.visitor;

// Concrete Visitor
class Owner implements Visitor {
   @Override
   public void visit(Bathroom room) {
      System.out.println("Visitor visits bathroom");
      room.turnOnLight();
   }

   @Override
   public void visit(Bedroom room) {
      System.out.println("Visitor visits bedroom");
      room.turnOffLight();
   }
}
