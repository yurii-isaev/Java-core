package behavioral.mediator.en;

public class SimpleUser extends User {

   public SimpleUser(Chat chat, String name) {
      super(chat, name);
   }

   @Override
   void getMessage(String message) {
      System.out.println("User " + getName() + " get massage '" + message + "'");
   }
}
