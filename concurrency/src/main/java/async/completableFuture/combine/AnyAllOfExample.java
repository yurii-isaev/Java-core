package async.completableFuture.combine;

import java.util.concurrent.*;

/**
 * CompletableFuture.allOf() - это статический метод класса CompletableFuture,
 * который позволяет объединить несколько CompletableFuture в один CompletableFuture,
 * который завершится, когда все исходные CompletableFuture завершатся.
 */
public class AnyAllOfExample {

   public static void delay(int seconds) {
      try {
         TimeUnit.SECONDS.sleep(seconds);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   public static CompletableFuture<Integer> future1() {
      return CompletableFuture.supplyAsync(() -> {
         System.out.println("future1 - " + Thread.currentThread().getName());
         delay(2);
         return Integer.valueOf(12);
      });
   }

   public static CompletableFuture<Double> future2() {
      return CompletableFuture.supplyAsync(() -> {
         System.out.println("future2 - " + Thread.currentThread().getName());
         delay(2);
         if (true) throw new RuntimeException("I am runtime error");
         return 1.23d;
      }).exceptionally(throwable -> {
         System.out.println("Error " + throwable.getMessage());
         return Double.NaN;
      });
   }

   public static CompletableFuture<String> future3() {
      return CompletableFuture.supplyAsync(() -> {
         System.out.println("future3 - " + Thread.currentThread().getName());
         delay(1);
         return "String";
      });
   }

   public static void main(String[] args) {
      long startTime = System.currentTimeMillis();
      System.out.println("Start: " + Thread.currentThread().getName());

      CompletableFuture<Integer> future1 = future1();
      CompletableFuture<Double> future2 = future2();
      CompletableFuture<String> future3 = future3();

      CompletableFuture<DataWrapper> future = CompletableFuture
          .allOf(future1, future2, future3)
          .thenApply(ignore -> {
             return new DataWrapper(future1.join(), future2.join(), future3.join());
      });

      future.thenAccept(System.out::println);
      future.join();
      long endTime = System.currentTimeMillis();
      System.out.println("Time Taken - " + (endTime - startTime) / 1000);
      System.out.println("End: " + Thread.currentThread().getName());

      /*
      Start: main
      future1 - ForkJoinPool.commonPool-worker-1
      future2 - ForkJoinPool.commonPool-worker-2
      future3 - ForkJoinPool.commonPool-worker-3
      Error java.lang.RuntimeException: I am runtime error
      DataWrapper{aInteger=12, aDouble=NaN, aString='String'}
      Time Taken - 2
      End: main
       */
   }

   static class DataWrapper {
      Integer aInteger;
      Double aDouble;
      String aString;

      public DataWrapper(Integer aInteger, Double aDouble, String aString) {
         this.aInteger = aInteger;
         this.aDouble = aDouble;
         this.aString = aString;
      }

      @Override
      public String toString() {
         return "DataWrapper{" +
             "aInteger=" + aInteger +
             ", aDouble=" + aDouble +
             ", aString='" + aString + '\'' +
             '}';
      }
   }
}
