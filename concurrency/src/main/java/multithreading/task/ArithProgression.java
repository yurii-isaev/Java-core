package multithreading.task;

import static java.lang.Thread.*;

/**
 * Задание:
 * Найти сумму членов арифметической прогрессии
 */

class ArithProgression {
   static final int FROM_NUMBER_FIRST_THREAD = 1;
   static final int TO_NUMBER_FIRST_THREAD = 500;
   static final int FROM_NUMBER_SECOND_THREAD = 501;
   static final int TO_NUMBER_SECOND_THREAD = 1000;

   public static void main(String[] args) throws InterruptedException {
      ProgressionSum firstTask = new ProgressionSum(FROM_NUMBER_FIRST_THREAD, TO_NUMBER_FIRST_THREAD);
      Thread thread1 = new Thread(firstTask);
      thread1.start();

      ProgressionSum secondTask = new ProgressionSum(FROM_NUMBER_SECOND_THREAD, TO_NUMBER_SECOND_THREAD);
      Thread thread2 = new Thread(secondTask);
      thread2.start();

      // Main thread
      waitThread(thread1, thread2);
      final int resultNumsSum = firstTask.resultNumber + secondTask.resultNumber;
      System.out.printf("%s : %d \n", currentThread().getName(), resultNumsSum);

      //Thread-0 : 125250
      //Thread-1 : 375250
      //main     : 500500
   }

   private static void waitThread(final Thread... threads) throws InterruptedException {
      // sleep(1000);
      for (Thread thread : threads) {
         thread.join();
      }
   }

   static class ProgressionSum implements Runnable {
      int resultNumber = 0;
      final int fromNumber;
      final int toNumber;

      public ProgressionSum(int fromNumber, int toNumber) {
         this.fromNumber = fromNumber;
         this.toNumber = toNumber;
      }

      @Override
      public void run() {
         for (int i = fromNumber; i <= toNumber; i++) {
            resultNumber = resultNumber + i;
         }
         System.out.printf("%s : %d \n", currentThread().getName(), resultNumber);
      }
   }
}
