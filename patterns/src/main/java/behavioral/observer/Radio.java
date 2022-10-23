package behavioral.observer;

/**
 * Observer
 */

public class Radio implements EventListener {

   @Override
   public void handleEvent() {
      System.out.println("Radio plays");
   }
}
