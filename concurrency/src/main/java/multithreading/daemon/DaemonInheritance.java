package multithreading.daemon;

public class DaemonInheritance {
   public static void main(String[] args) throws InterruptedException {

      Thread firstDaemonThread = new Thread(() -> {
         showThreadState(Thread.currentThread());
         Thread secondDaemonThread = new Thread(() -> showThreadState(Thread.currentThread()));
         secondDaemonThread.start();

         try {
            secondDaemonThread.join(); // Происходит наследование демон статуса
         } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
         }
      });

      // Установка свойства демона должна быть до того, как поток начнет выполнятся
      firstDaemonThread.setDaemon(true);
      firstDaemonThread.start();
      firstDaemonThread.join();
   }

   private static void showThreadState(Thread thread) {
      System.out.printf("%s : %b\n", thread.getName(), thread.isDaemon());
   }
}
