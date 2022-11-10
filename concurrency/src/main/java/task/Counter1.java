package task;

/**
 * Задание:
 * 1. Создать два счетчика (внутренний и глобальный);
 * 2. Создать и запустить два потока и перебрать цыкл из 20 элементов;
 */

public class Counter1 implements Runnable{
   private int count;
   private static int globalCount;

   @Override
   public void run() {
      while (count < 20) {
         count++;
         globalCount++; // 60

         try {
            Thread.sleep(100); // создает рассинхрон потоков
         } catch (InterruptedException e) {
            throw new RuntimeException(e);
         }

         System.out.println(Thread.currentThread().getName() +
             " counter " + count +
             " globalCount: " + globalCount);
      }
   }

   public static void main(String[] args) {
      new Thread(new Counter1()).start();
      new Thread(new Counter1()).start();
      new Thread(new Counter1()).start();
   }
}
