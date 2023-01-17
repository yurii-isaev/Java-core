package async.future;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Основные отличия между Future и CompletableFuture в Java включают следующее:
 * 1. Асинхронное и синхронное использование:
 * Future представляет асинхронную задачу
 * и предоставляет базовые методы для получения результата или отмены задачи.
 * С другой стороны, CompletableFuture представляет комбинируемую асинхронную задачу,
 * которая также может быть использована синхронно для последовательного выполнения операций
 * или комбинирования результатов.
 * <p>
 * 2. Комбинирование и композиция:
 * CompletableFuture предоставляет богатый набор методов для комбинирования и композиции задач.
 * Вы можете объединять несколько CompletableFuture с помощью методов,
 * таких как thenCombine(), thenCompose(), thenAcceptBoth(), и т.д.,
 * чтобы создавать сложные потоки выполнения задач.
 * <p>
 * 3. Обработка исключений:
 * CompletableFuture предоставляет более удобные способы обработки исключений в сравнении с Future.
 * Вы можете использовать методы, такие как exceptionally(), handle(), whenComplete(),
 * чтобы определить обработчики исключений или выполнить код после завершения задачи.
 * <p>
 * 4. Комбинированные операции:
 * CompletableFuture поддерживает комбинированные операции, такие как allOf(), anyOf(),
 * которые позволяют объединять несколько задач
 * и выполнять действия после завершения всех задач или любой из них.
 * <p>
 * 5. Отмена задачи:
 * CompletableFuture предоставляет более гибкие возможности для отмены задачи
 * с помощью методов cancel() и completeExceptionally().
 * Вы также можете комбинировать CompletableFuture с java.util.concurrent.Executor
 * и использовать метод completeOnTimeout() для установки тайм-аута выполнения задачи.
 * <p>
 * 6. Обратная совместимость:
 * CompletableFuture является расширением Future и предоставляет совместимость с ним.
 * Вы можете получить CompletableFuture из Future с помощью метода CompletableFuture.completedFuture()
 * или преобразовать CompletableFuture в Future с помощью метода toCompletableFuture().
 * <p>
 * В целом, CompletableFuture предоставляет более продвинутые возможности для работы с асинхронными задачами,
 * включая комбинирование, композицию, обработку исключений и отмену задачи.
 * Если вам требуется более сложная функциональность, чем предоставляет Future,
 * CompletableFuture может быть более подходящим выбором.
 * Однако, если вам нужна простая асинхронная задача без дополнительных возможностей,
 * Future может быть достаточным.
 */

public class WhyNotFuture {
   public static void main(String[] args) throws InterruptedException, ExecutionException {
      //useFuture();
      useCompletableFuture();
   }

   private static void useFuture() throws ExecutionException, InterruptedException {
      ExecutorService executor = Executors.newFixedThreadPool(10);
      System.out.println("Thread: " + Thread.currentThread().getName());

      // Неблокирующая задача в потоке пула
      Future<List<Integer>> task = executor.submit(() -> {
         System.out.printf("Start task: %s\n", Thread.currentThread().getName());
         delay(5);
         System.out.printf("End task: %s\n", Thread.currentThread().getName());
         return Arrays.asList(1, 2, 3, 4);
      });

      System.out.printf("Delay: %s\n", Thread.currentThread().getName());
      delay(10);
      System.out.printf("After delay: %s\n", Thread.currentThread().getName());

      System.out.printf("Submit from %s\n", Thread.currentThread().getName());
      List<Integer> list = task.get();
      System.out.println(list);
      executor.shutdown();

      /*
      Thread: main
      Delay: main
      Start task: pool-1-thread-1
      End task: pool-1-thread-1
      After delay: main
      Submit from main
      [1, 2, 3, 4]
       */
   }

   private static void useCompletableFuture() {
      /**
       * newCachedThreadPool() - это метод из класса Executors в пакете java.util.concurrent,
       * который создает исполнительный сервис с кэшированным пулом потоков.
       * Кэшированный пул потоков автоматически увеличивает
       * или уменьшает количество потоков в зависимости от нагрузки.
       * Если в пуле есть свободный поток, задача будет передана этому потоку для выполнения.
       * Если все потоки заняты, будет создан новый поток.
       * Если поток неактивен в течение некоторого времени, он будет удален из пула.
       */
      ExecutorService executor = Executors.newCachedThreadPool();

      System.out.println("Thread: " + Thread.currentThread().getName());
      AtomicReference<List<Integer>> list = new AtomicReference<>();

      // supply async task
      Runnable task = () -> {
         System.out.printf("Start task: %s\n", Thread.currentThread().getName());
         delay(5);
         list.set(Arrays.asList(1, 2, 3, 4));
         System.out.printf("End task: %s\n", Thread.currentThread().getName());
      };

      CompletableFuture<Void> future = CompletableFuture.runAsync(task, executor);

      System.out.printf("Delay: %s\n", Thread.currentThread().getName());
      delay(10);
      System.out.printf("After delay: %s\n", Thread.currentThread().getName());

      /**
       * Метод join() является одним из методов класса CompletableFuture в Java.
       * Он используется для ожидания завершения асинхронной задачи и получения ее результата.
       * Когда вы вызываете метод join() на экземпляре CompletableFuture,
       * текущий поток будет блокироваться до тех пор, пока задача не завершится.
       * Затем метод join() вернет результат выполнения задачи или выбросит исключение,
       * если задача завершилась с ошибкой.
       */
      future.join();

      System.out.printf("Submit from %s\n", Thread.currentThread().getName());
      System.out.println(list);
      executor.shutdown();

      /*
      Thread: main
      Delay: main
      Start task: pool-1-thread-1
      End task: pool-1-thread-1
      After delay: main
      Submit from main
      [1, 2, 3, 4]
       */
   }

   public static void delay(int sec) {
      try {
         TimeUnit.SECONDS.sleep(sec);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }
}
