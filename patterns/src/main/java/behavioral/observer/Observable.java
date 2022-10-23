package behavioral.observer;

/**
 * Observable(Publisher)
 */

public interface Observable {
   void addConsumer(EventListener consumer);
   void removeConsumer(EventListener consumer);
   void notifyConsumer();
}
