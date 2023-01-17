package multithreading.daemon;

import java.util.concurrent.TimeUnit;

public class DaemonTask {
   public static void main(String[] args) throws InterruptedException {
      Thread thread = new Thread(new Task());
      thread.setDaemon(true);
      thread.start();
      TimeUnit.SECONDS.sleep(5); // сон главного потока
   }

   private static class Task implements Runnable {
      @Override
      public void run() {
         try {
            System.out.println("Daemon is working");
            TimeUnit.SECONDS.sleep(1);
         } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
         } finally {
            System.out.println("Daemon is dead");
         }
      }
   }
}
