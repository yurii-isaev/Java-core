package behavioral.mediator.cl;

// Concrete Colleague
class User implements Colleague {
   private String name;
   private Mediator mediator;

   public User(String name, Mediator mediator) {
      this.name = name;
      this.mediator = mediator;
   }

   @Override
   public void sendMessage(String message) {
      System.out.println(name + " sends: " + message);
      mediator.sendMessage(message, this);
   }

   @Override
   public void receiveMessage(String message) {
      System.out.println(name + " receives: " + message);
   }
}
