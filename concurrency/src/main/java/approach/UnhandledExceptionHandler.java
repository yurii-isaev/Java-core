package approach;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.*;

public class UnhandledExceptionHandler {
   public static void main(String[] args) throws InterruptedException {

      UncaughtExceptionHandler handler = (t, e) ->
          System.out.printf("Exception was thrown with message '%s' in thread '%s'\n",
              e.getMessage(), t.getName());

      ThreadFactory factory = new ExceptionHandlerFactory(handler);

      // Default Uncaught Exception Handler
      // Thread.setDefaultUncaughtExceptionHandler(handler);

      //Thread thread1 = new Thread(new Task());
      //thread1.setUncaughtExceptionHandler(handler);
      //thread1.setDaemon(true);

      Thread thread1 = factory.newThread(new Task());
      thread1.start();
      thread1.join();

      TimeUnit.SECONDS.sleep(3);

      //Thread thread2 = new Thread(new Task());
      //thread2.setDaemon(true);
      Thread thread2 = factory.newThread(new Task());
      thread2.start();
      thread2.join();

      //Exception was thrown with message 'This exception' in thread 'Thread-0'
      //Exception was thrown with message 'This exception' in thread 'Thread-1'
   }

   private static class Task implements Runnable {
      @Override
      public void run() {
         System.out.println(Thread.currentThread().isDaemon());
         throw new RuntimeException("This exception");
      }
   }

   private static class ExceptionHandlerFactory implements ThreadFactory {
      public final UncaughtExceptionHandler handler;

      public ExceptionHandlerFactory(UncaughtExceptionHandler handler) {
         this.handler = handler;
      }

      @Override
      public Thread newThread(Runnable r) {
         Thread thread = new Thread(r);
         thread.setUncaughtExceptionHandler(handler);
         thread.setDaemon(true);
         return thread;
      }
   }
}
