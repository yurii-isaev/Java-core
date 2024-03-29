package async.completableFuture.combine;

import java.util.concurrent.CompletableFuture;

public class ExceptionHandling {
   public static void main(String[] args) {
      boolean error = true;

      CompletableFuture<String> task = CompletableFuture
          .supplyAsync(() -> {
             if (error) throw new RuntimeException("Error@Future");
             return "success";
          })
          .exceptionally((e) -> {
             System.out.println(e.getMessage());
             return "null";
          });

      System.out.println(task.join());

      /*
      java.lang.RuntimeException: Error@Future
      null
       */
   }
}
