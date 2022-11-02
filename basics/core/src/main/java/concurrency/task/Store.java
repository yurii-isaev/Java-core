package concurrency.task;

/**
 * Consumer - Producer
 *
 * Методы взаимодействия между потоками выполнения:
 *
 * wait(): освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор,
 * пока другой поток не вызовет метод notify()
 *
 * notify(): продолжает работу потока, у которого ранее был вызван метод wait()
 *
 * notifyAll(): возобновляет работу всех потоков, у которых ранее был вызван метод wait(
 */

public class Store {
   private int item;

   public synchronized void put() {
      while (item >= 3) {
         try {
            wait();
         } catch (InterruptedException e) {
            throw new RuntimeException(e);
         }
      }
      item++;
      System.out.println("Producer add 1 product. When store have: " + item);
      notify();
   }

   public synchronized void get() {
      while (item < 1) {
         try {
            wait();
         } catch (InterruptedException e) {
            throw new RuntimeException(e);
         }
      }
      item--;
      System.out.println("Consumer bought 1 product. When store have: " + item);
      notify();
   }
}

class Producer implements Runnable {
   private final Store store;

   public Producer(Store store) {
      this.store = store;
   }

   @Override
   public void run() {
      for (int i = 0; i < 6; i++) {
         store.put();
      }
   }
}

class Consumer implements Runnable {
   private final Store store;

   public Consumer(Store store) {
      this.store = store;
   }

   @Override
   public void run() {
      for (int i = 0; i < 6; i++) {
         store.get();
      }
   }
}

class Main {
   public static void main(String[] args) {
      Store store = new Store();
      Producer producer = new Producer(store);
      Consumer consumer = new Consumer(store);
      new Thread(consumer).start();
      new Thread(producer).start();
   }
}
