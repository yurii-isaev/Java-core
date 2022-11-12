package approach;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {
   public static void main(String[] args) throws InterruptedException {

      Thread communicatingThread = new Thread(() -> {
         try {
            while (!Thread.currentThread().isInterrupted()) {
               doRequest();
            }
         } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
         }
      });
      communicatingThread.start();

      TimeUnit.SECONDS.sleep(3);

      Thread stoppingThread = new Thread(() -> {
         communicatingThread.interrupt();
         stopServer();
      });
      stoppingThread.start();
   }

   private static void stopServer() {
      System.out.println("Server was stopped.");
   }

   public static void doRequest() throws InterruptedException {
      System.out.println("\nRequest was sent.");
      TimeUnit.SECONDS.sleep(1);
      System.out.println("Response was received.");
   }
}
