package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Observable
 */

public class Switcher implements Observable {
   private final List<EventListener> listeners; // Subscribers

   public Switcher() {
      this.listeners = new ArrayList<>();
      System.out.println("Switcher on");
   }

   @Override
   public void addConsumer(EventListener listener) {
      if (listener != null) {
         listeners.add(listener);
      }
   }

   @Override
   public void removeConsumer(EventListener listener) {
      listeners.remove(listener);
   }

   @Override
   public void notifyConsumer() {
      listeners.forEach(l -> l.handleEvent());
   }
}
