package behavioral.observer;

/**
 * Observer
 */

public class Lamp implements EventListener {

   @Override
   public void handleEvent() {
      System.out.println("Lamp light on");
   }
}
