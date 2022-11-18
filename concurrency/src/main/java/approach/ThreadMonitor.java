package approach;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class ThreadMonitor {

   public static final class Counter {
      private int count;
      public static final int INCREMENT_AMOUNT_FIRST_COUNTER = 500;
      public static final int INCREMENT_AMOUNT_SECOND_COUNTER = 600;

      public synchronized void increment() {
         count++;
      }

      public static void main(String[] args) {
         Counter firstCounter = new Counter();
         Counter secondCounter = new Counter();

         // Два потока синхронизируются по монитору объекта firstCounter
         Thread firstThread = createIncrementCounterThread(INCREMENT_AMOUNT_FIRST_COUNTER,
             i -> firstCounter.increment());
         Thread secondThread = createIncrementCounterThread(INCREMENT_AMOUNT_FIRST_COUNTER,
             i -> firstCounter.increment());

         // Два потока синхронизируются по монитору объекта secondCounter
         Thread thirdThread = createIncrementCounterThread(INCREMENT_AMOUNT_SECOND_COUNTER,
             i -> secondCounter.increment());
         Thread fourthThread = createIncrementCounterThread(INCREMENT_AMOUNT_SECOND_COUNTER,
             i -> secondCounter.increment());

         threadRunner(firstThread, secondThread, thirdThread, fourthThread);

         System.out.println(firstCounter.count);  // 1000
         System.out.println(secondCounter.count); // 1200
      }

      private static void threadRunner(Thread... threads) {
         Arrays.stream(threads).forEach(thread -> {
            thread.start();
            try {
               thread.join();
            } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
            }
         });
      }

      public static Thread createIncrementCounterThread(int incAmount, IntConsumer operation) {
         return new Thread(() -> IntStream.range(0, incAmount)
             .forEach(operation));
      }
   }
}
