package daemon;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

/**
 * В Java есть два типа потоков: обычные потоки (user threads) и потоки-демоны (daemon threads).
 * Потоки-демоны являются фоновыми потоками,
 * которые работают в фоновом режиме и не препятствуют завершению программы,
 * когда все обычные потоки завершаются.
 * <p>
 * Потоки-демоны автоматически завершаются, когда все обычные потоки завершаются.
 * Это означает, что если все обычные потоки завершили свою работу, программа завершится,
 * даже если потоки-демоны еще не закончили свою работу.
 * Поэтому потоки-демоны обычно используются для выполнения фоновых задач,
 * которые не должны препятствовать завершению программы.
 * <p>
 * Важно отметить, что поток-демон не должен выполнять критически важные операции,
 * так как его работа может быть прервана в любой момент, когда все обычные потоки завершаются.
 */

public class DaemonThread {
   public static void main(String[] args) throws InterruptedException {
      Thread thread = new Thread(new Task());
      thread.setDaemon(true);
      thread.start();
      TimeUnit.SECONDS.sleep(3);
      showThreadState(); // main is alive
   }

   private static class Task implements Runnable {
      @Override
      public void run() {
         while (true) {
            System.out.println("I'm working");
            try {
               TimeUnit.SECONDS.sleep(2);
               showThreadState();
            } catch (InterruptedException e) {
               currentThread().interrupt();
               System.out.println("Thread was interrupted");
            }
         }
      }
   }

   private static void showThreadState() {
      System.out.println(currentThread().getName());
      System.out.println(currentThread().isAlive());
      System.out.println(currentThread().isDaemon());
   }
}
