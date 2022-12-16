package behavioral.mediator.en;

import java.util.*;

public class TextChat implements Chat {
   User admin;
   List<User> users = new ArrayList<>();

   public void setAdmin(User admin) {
      if (admin != null && admin instanceof Admin) {
         this.admin = admin;
      } else {
         throw new RuntimeException("Not Enough Right");
      }
   }

   public void addUser(User user) {
      if (admin == null) {
         throw new RuntimeException("There is no admin in the chat");
      }
      if (user instanceof User) {
         users.add(user);
      } else {
         throw new RuntimeException("Admin can't enter another chat");
      }
   }

   @Override
   public void sendMessage(String message, User colleague) {
      if (colleague instanceof Admin) {
         for (User user : users) {
            user.getMessage(colleague.getName() + ": " + message);
         }
      }
      if (colleague instanceof User) {
         for (User user : users) {
            if (user != colleague && user.isEnable()) {
               user.getMessage(colleague.getName() + ": " + message);
            }
         }
         if (admin.isEnable()) {
            admin.getMessage(colleague.getName() + ": " + message);
         }
      }
   }
}




























