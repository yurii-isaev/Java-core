package behavioral.mediator.en;

public class Main {
   public static void main(String[] args) {
      TextChat chat = new TextChat();

      User admin = new Admin  (chat, Colleague.ADMIN.value());
      User u1 = new SimpleUser(chat, Colleague.PETR.name());
      User u2 = new SimpleUser(chat, Colleague.VLAD.name());
      User u3 = new SimpleUser(chat, Colleague.ALEX.name());
      u2.setEnable(false);

      chat.setAdmin(admin);
      chat.addUser(u1);
      chat.addUser(u2);
      chat.addUser(u3);

      u1.sendMessage("Hello");

      /*
      Output:
      User Alex get massage 'Petr: Hello'
      Admin Ivan get massage 'Petr: Hello'
      */
   }
}
