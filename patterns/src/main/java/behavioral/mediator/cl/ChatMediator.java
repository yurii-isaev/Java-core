package behavioral.mediator.cl;

import java.util.*;

// Concrete Mediator
class ChatMediator implements Mediator {
   private List<Colleague> colleagues;

   public ChatMediator() {
      colleagues = new ArrayList<>();
   }

   public void addColleague(Colleague colleague) {
      colleagues.add(colleague);
   }

   @Override
   public void sendMessage(String message, Colleague colleague) {
      for (Colleague c : colleagues) {
         if (c != colleague) {
            c.receiveMessage(message);
         }
      }
   }
}
