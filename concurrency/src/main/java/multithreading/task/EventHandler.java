package multithreading.task;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * Задание:
 * Подсчитать сколько секунд осталось от текущей даты до переданной даты с выводом на консоль
 * <p>
 * 1. Программа которая ждет определенное событие и запускает его;
 * 2. После запуска всех потоков завершает выплнение пулла потоков.
 *
 * Future является интерфейсом, представляющим результат асинхронной операции.
 * Он используется для получения результата выполнения задачи,
 * которая может занимать продолжительное время или выполняться в фоновом потоке.
 */

public class EventHandler implements Callable {
   private final LocalDateTime eventDate;

   public EventHandler(LocalDateTime eventDate) {
      this.eventDate = eventDate;
   }

   @Override
   public String call() throws InterruptedException {
      long d;
      while ((d = Duration.between(LocalDateTime.now(), eventDate).toSeconds()) >= 0) {

         System.out.println("Event: " + Thread.currentThread().getName() +
             " will be started in " + d + " seconds ");

         Thread.sleep(1000);
      }

      return "Event: " + Thread.currentThread().getName() + " started";
   }

   public static void main(String[] args) throws ExecutionException, InterruptedException {
      ExecutorService pool = Executors.newFixedThreadPool(10);
      LocalDateTime dateTime = LocalDateTime.now();
      EventHandler eventHandler1 = new EventHandler(dateTime.plusSeconds(5));
      Callable<String> eventHandler2 = new EventHandler(dateTime.plusSeconds(10));
      Callable<String> eventHandler3 = new EventHandler(dateTime.plusSeconds(15));
      Callable<String> eventHandler4 = new EventHandler(dateTime.plusSeconds(20));
      Callable<String> eventHandler5 = new EventHandler(dateTime.plusSeconds(25));

      Future<String> res1 = pool.submit(eventHandler1);
      Future<String> res2 = pool.submit(eventHandler2);
      Future<String> res3 = pool.submit(eventHandler3);
      Future<String> res4 = pool.submit(eventHandler4);
      Future<String> res5 = pool.submit(eventHandler5);

      // Получение результата асинхронных операции
      System.out.println(res1.get());
      System.out.println(res2.get());
      System.out.println(res3.get());
      System.out.println(res4.get());
      System.out.println(res5.get());

      pool.shutdown();
   }
}
