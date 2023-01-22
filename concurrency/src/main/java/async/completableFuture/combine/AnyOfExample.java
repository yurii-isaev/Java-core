package async.completableFuture.combine;

import java.util.concurrent.CompletableFuture;

/**
 * Метод anyOf принимает массив CompletableFuture и возвращает новый CompletableFuture,
 * который завершается, когда любой из переданных CompletableFuture завершается.
 * Результатом этого нового CompletableFuture будет результат завершившегося первым CompletableFuture.
 */

public class AnyOfExample {
   public static CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
      try {
         Thread.sleep(2000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      return "result 1";
   });

   static CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      return "result 2";
   });

   public static void main(String[] args) {
      CompletableFuture<Void> anyFuture = CompletableFuture
          .anyOf(future1, future2)
          .thenAccept(result -> {
             System.out.println("First completed result: " + result);
          });
      anyFuture.join();
   }
}
