package approach;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class AtomicState {
   public static int counter = 0; // общий счётчик

   public static int firstCounter = 0;
   public static int secondCounter = 0;

   public static final int INCREMENT_AMOUNT_FIRST_THREAD = 500;
   public static final int INCREMENT_AMOUNT_SECOND_THREAD = 600;

   public static void main(String[] args) throws InterruptedException {
      Thread firstThread = createIncrementCommonCounterThread(INCREMENT_AMOUNT_FIRST_THREAD);
      Thread secondThread = createIncrementCommonCounterThread(INCREMENT_AMOUNT_SECOND_THREAD);

      Thread thirdThread = createIncrementCounterThread(INCREMENT_AMOUNT_FIRST_THREAD,
          i -> getIncrementFirstCounter());
      Thread fourthThread = createIncrementCounterThread(INCREMENT_AMOUNT_SECOND_THREAD,
          i -> getIncrementSecondCounter());

      threadRunner(firstThread, secondThread, thirdThread, fourthThread);

      System.out.println(counter);       // 1100
      System.out.println(firstCounter);  // 500
      System.out.println(secondCounter); // 600
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

   public static Thread createIncrementCommonCounterThread(int incAmount) {
      return new Thread(() -> IntStream.range(0, incAmount)
          .forEach(i -> getIncrementCommonCountValue())
      );
   }

   // Атомарная работа с ресурсом
   private static synchronized int getIncrementCommonCountValue() {
      return counter++;
   }

   public static Thread createIncrementCounterThread(int incAmount, IntConsumer operation) {
      return new Thread(() -> IntStream.range(0, incAmount)
          .forEach(operation)
      );
   }

   private static void getIncrementFirstCounter() {
      firstCounter++;
   }

   private static void getIncrementSecondCounter() {
      secondCounter++;
   }
}
