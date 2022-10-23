package behavioral.observer;

/**
 * Observer(Subscriber)
 */

@FunctionalInterface
public interface EventListener {
   void handleEvent();
}
