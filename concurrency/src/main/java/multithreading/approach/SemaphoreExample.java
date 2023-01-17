package multithreading.approach;

import java.util.concurrent.Semaphore;

/**
 * Семафоры используются для контроля доступа к общему ресурсу определенного количества потоков.
 * Семафоры имеют две основные операции:
 * 1. acquire(): Эта операция запрашивает доступ к семафору.
 * Если семафор имеет доступные разрешения, то поток получает разрешение и продолжает выполнение.
 * Если все разрешения заняты, поток блокируется до тех пор, пока не будет доступно разрешение.
 * 2. release(): Эта операция освобождает разрешение семафора.
 * Если есть потоки, ожидающие разрешения, один из них получает разрешение и продолжает выполнение.
 * Если нет ожидающих потоков, разрешение просто освобождается для будущего использования.
 * <p>
 * В этом примере создается семафор с двумя разрешениями (SEMAPHORE_PERMITS).
 * Пять потоков пытаются получить разрешение семафора, но только два потока могут получить разрешение одновременно.
 * Остальные потоки будут блокированы до тех пор, пока разрешение не будет освобождено.
 */

public class SemaphoreExample {
   private static final int THREAD_COUNT = 5;
   private static final int SEMAPHORE_PERMITS = 2;
   private static Semaphore semaphore = new Semaphore(SEMAPHORE_PERMITS);

   public static void main(String[] args) {
      for (int i = 0; i < THREAD_COUNT; i++) {
         Thread thread = new Thread(new Worker());
         thread.start();
      }
   }

   static class Worker implements Runnable {
      @Override
      public void run() {
         try {
            System.out.printf("Thread %s is waiting for a permit\n", Thread.currentThread().getName());
            semaphore.acquire();
            System.out.printf("Thread %s gets a permit\n", Thread.currentThread().getName());
            // Выполнение работы
            Thread.sleep(2000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         } finally {
            System.out.printf("Thread %s releases the permit\n", Thread.currentThread().getName());
            semaphore.release();
         }
      }
   }

   /*
   Thread Thread-0 is waiting for a permit
   Thread Thread-1 is waiting for a permit
   Thread Thread-1 gets a permit
   Thread Thread-2 is waiting for a permit
   Thread Thread-3 is waiting for a permit
   Thread Thread-4 is waiting for a permit
   Thread Thread-0 gets a permit
   Thread Thread-0 releases the permit
   Thread Thread-1 releases the permit
   Thread Thread-2 gets a permit
   Thread Thread-3 gets a permit
   Thread Thread-2 releases the permit
   Thread Thread-3 releases the permit
   Thread Thread-4 gets a permit
   Thread Thread-4 releases the permit
    */
}
