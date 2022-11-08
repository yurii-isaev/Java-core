package threadpool;

import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable {
   CommonResource resource;
   ReentrantLock locker;

   public CountThread(CommonResource resource, ReentrantLock lock) {
      this.resource = resource;
      this.locker = lock;
   }

   @Override
   public void run() {
      locker.lock(); // устанавливаем блокировку
      try {
         resource.x = 1;
         for (int i = 0; i < 5; i++) {
            System.out.printf("%s %d \n", Thread.currentThread().getName(), resource.x);
            resource.x++;
            Thread.sleep(100);
         }
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      } finally {
         locker.unlock(); // снимаем блокировку
      }
   }

   static class CommonResource {
      int x = 0;
   }

   static class Main {
      public static void main(String[] args) {
         CommonResource resource = new CommonResource();
         ReentrantLock lock = new ReentrantLock();
         for (int i = 0; i < 6; i++) { // создание и запуск пула потоков
            Thread thread = new Thread(new CountThread(resource, lock));
            thread.setName("Thread " + i);
            thread.start();
         }
      }
   }
}
