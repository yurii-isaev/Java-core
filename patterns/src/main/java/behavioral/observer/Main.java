package behavioral.observer;

/**
 * Шаблон проектирования - наблюдатель
 */

public class Main {
   public static void main(String[] args) {
      Switcher switcher = new Switcher();
      Lamp lamp = new Lamp();
      Radio radio = new Radio();
      switcher.addConsumer(lamp);
      switcher.addConsumer(radio);
      switcher.notifyConsumer();
   }
}
