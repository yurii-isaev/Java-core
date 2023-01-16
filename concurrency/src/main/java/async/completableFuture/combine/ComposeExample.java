package async.completableFuture.combine;

import java.util.concurrent.*;

/**
 * CompletableFuture.thenCompose() позволяет компоновать два CompletableFuture,
 * где результат первого CompletableFuture используется в качестве
 * входного аргумента для второго CompletableFuture.
 */

public class ComposeExample {

   public static void delay(int seconds) {
      try {
         TimeUnit.SECONDS.sleep(seconds);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   public static CompletableFuture<String> getUserDetails() {
      return CompletableFuture.supplyAsync(() -> {
         System.out.println("getUserDetails() - " + Thread.currentThread().getName());
         delay(2);
         return "UserDetails";
      });
   }

   public static CompletableFuture<String> getWishList(String user) {
      return CompletableFuture.supplyAsync(() -> {
         System.out.println("getWishList() - " + user + " - " + Thread.currentThread().getName());
         delay(3);
         return "User's WishList";
      });
   }

   public static void main(String[] args) {
      long startTime = System.currentTimeMillis();
      System.out.println("Start: " + Thread.currentThread().getName());

      CompletableFuture<String> task = getUserDetails().thenCompose(s -> {
         System.out.println("Thread task - " + Thread.currentThread().getName());
         System.out.println("Sending email with report from " + s);
         return getWishList(s);
      });

      System.out.println("Delay: " + Thread.currentThread().getName());
      delay(4);
      System.out.println("After delay: " + Thread.currentThread().getName());

      System.out.println(task.join());
      long endTime = System.currentTimeMillis();
      System.out.println("Time taken " + (endTime - startTime) / 1000);

      System.out.println("End: " + Thread.currentThread().getName());

      /*
      Start: main
      Delay: main
      getUserDetails() - ForkJoinPool.commonPool-worker-1
      Thread task - ForkJoinPool.commonPool-worker-1
      Sending email with report from UserDetails
      getWishList() - UserDetails - ForkJoinPool.commonPool-worker-1
      After delay: main
      User's WishList
      Time taken 5
      End: main
       */
   }
}
