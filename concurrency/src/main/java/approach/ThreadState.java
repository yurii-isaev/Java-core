package approach;

/**
 * Если в программе запущено несколько потоков и в одно из них произошло исключение,
 * то остальные потоки продолжат выполняться.
 * Метод join() используется для ожидания завершения потока, на котором вызывается данный метод.
 * Аргумент 100 указывает время ожидания в миллисекундах.
 * Это означает, что текущий поток будет ждать, пока mainThread не завершится, но не более 100 миллисекунд.
 * Если mainThread завершится до истечения указанного времени, метод join() вернет управление.
 * <p>
 * Метод join() без аргументов используется для ожидания завершения потока, на котором вызывается данный метод.
 * Текущий поток будет заблокирован и будет ожидать, пока mainThread не завершится.
 * После завершения mainThread текущий поток продолжит свое выполнение.
 */

public class ThreadState {
   public static void main(String[] args) throws InterruptedException {
      Thread mainThread = Thread.currentThread(); // ссылка на главный поток

      Thread thread0 = new Thread(() -> {
         // mainThread.join(10);
         showThreadState(mainThread);             // main : TIMED_WAITING
         //Thread.currentThread().join(100);
         showThreadState(Thread.currentThread()); // Thread-0 : RUNNABLE
      });

      Thread thread1 = new Thread(() -> {
         throw new RuntimeException();
      });

      showThreadState(mainThread); // main : RUNNABLE
      showThreadState(thread0);    // Thread-0 : NEW
      showThreadState(thread1);    // Thread-1 : NEW

      thread1.start();
      thread1.join();
      showThreadState(thread1); // Thread-1 : TERMINATED
      // Exception in thread "Thread-1" RuntimeException

      showThreadState(thread0); // Thread-0 : NEW
      thread0.start();

      mainThread.join(10);
      thread0.join();
      showThreadState(thread0); // Thread-0 : TERMINATED

      mainThread.join(); // программа будет ждать завершения

      //main : RUNNABLE
      //Thread-0 : NEW
      //Thread-1 : NEW
      //Thread-1 : TERMINATED
      //Thread-0 : NEW
      //main : TIMED_WAITING
      //Thread-0 : RUNNABLE
      //Exception in thread "Thread-1" RuntimeException
      //Thread-0 : TERMINATED
   }

   private static void showThreadState(Thread thread) {
      System.out.printf("%s : %s\n", thread.getName(), thread.getState());
   }
}
