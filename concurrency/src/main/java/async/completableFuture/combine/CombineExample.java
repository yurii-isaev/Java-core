package async.completableFuture.combine;

import java.util.concurrent.*;

/**
 * CompletableFuture.thenCombine() позволяет комбинировать
 * результаты двух завершенных CompletableFuture с помощью функции.
 */
public class CombineExample {

   public static void delay(int seconds) {
      try {
         TimeUnit.SECONDS.sleep(seconds);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   public static CompletableFuture<String> getUserEmail() {
      return CompletableFuture.supplyAsync(() -> {
         System.out.println("getUserEmail() - " + Thread.currentThread().getName());
         delay(2);
         return "tech.recipe@yt.com";
      });
   }

   public static CompletableFuture<String> getWeatherReport() {
      return CompletableFuture.supplyAsync(() -> {
         System.out.println("getWeatherReport() - " + Thread.currentThread().getName());
         delay(3);
         return "Weather Report of city is - Rainy";
      });
   }

   public static void main(String[] args) {
      long startTime = System.currentTimeMillis();
      System.out.println("Start: " + Thread.currentThread().getName());

      CompletableFuture<String> task = getUserEmail().thenCombine(getWeatherReport(), (e, w) -> {
         System.out.println("Sending email to " + e + " with report - " + w);
         return e + w;
      });

      System.out.println("Delay: " + Thread.currentThread().getName());
      delay(4);
      System.out.println("After delay: " + Thread.currentThread().getName());

      System.out.println(task.join());
      long endTime = System.currentTimeMillis();
      System.out.println("Time Taken - " + (endTime - startTime) / 1000);
      System.out.println("End: " + Thread.currentThread().getName());

      /*
      Start: main
      getUserEmail() - ForkJoinPool.commonPool-worker-1
      getWeatherReport() - ForkJoinPool.commonPool-worker-2
      Delay: main
      Sending email to tech.recipe@yt.com with report - Weather Report of city is - Rainy
      After delay: main
      tech.recipe@yt.comWeather Report of city is - Rainy
      Time Taken - 4
      End: main
       */
   }
}
