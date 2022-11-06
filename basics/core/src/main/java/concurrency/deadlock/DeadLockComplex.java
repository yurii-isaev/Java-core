package concurrency.deadlock;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

/**
 * Ключевое слово synchronized используется для обеспечения синхронизации доступа к общим ресурсам в многопоточной среде.
 * Когда метод или блок кода помечается как synchronized, он становится потокобезопасным,
 * то есть гарантируется, что только один поток может выполнить этот код в определенный момент времени.
 * <p>
 * Монитор. ключевое слово synchronized позволяет "войти в монитор объекта".
 * Монитор - это специальный объект, который следит за "состоянием" метода или объекта.
 * Он смотрит, "занят" он или "свободен" в данный момент.
 * <p>
 * Многие проблемы с потоками возникают тогда, когда два потока, используя один метод, мешают друг другу.
 * Они могут менять значения переменных, которые использует другой поток.
 * Атомарный - значит "неделимый" - в том смысле,
 * что операция может быть завершена одним потоком, и другой не может в ней ничего "напортить".
 */

public class DeadLockComplex {
   public static void main(String[] args) {
      List<Resource> resources = IntStream.range(0, 10)
          .mapToObj(Resource::new)
          .collect(Collectors.toList());

      // Функция разности двух индексов
      Comparator<Resource> comparator = (o1, o2) -> resources.indexOf(o1) - resources.indexOf(o2);

      ExecutorService pool = Executors.newFixedThreadPool(2);
      pool.execute(() -> handle(resources.get(0), resources.get(1), comparator));
      pool.execute(() -> handle(resources.get(1), resources.get(0), comparator));
      pool.shutdown();
   }

   public static void handle(Resource res1, Resource res2, Comparator<Resource> comparator) {
      // Решение проблемы - это установить очередность доступа потоков к ресурсам.
      Object lock1 = res1;
      Object lock2 = res2;
      if (comparator.compare(res1, res2) < 0) {
         lock1 = res2;
         lock2 = res1;
      }

      System.out.println(Thread.currentThread().getName() + " start");
      synchronized (lock1) {

         try {
            Thread.sleep(100);
         } catch (InterruptedException e) {
            throw new RuntimeException(e);
         }

         synchronized (lock2) {
            res1.setValue(res2.getValue());
         }
      }
      // первый поток запускается, захватывает монитор, останавливается на sleep.
      // Второй поток запускается, захватывает свой первый монитор,
      // а второй захватить не может, так как его удерживает первый поток.
      // Первый поток возобновляет работу после sleep,
      // но свой второй монитор так же не может захватить, так как его удерживает второй поток.
      System.out.println(Thread.currentThread().getName() + " end");
   }

   static class Resource {
      int value;

      public Resource(int value) {
         this.value = value;
      }

      public int getValue() {
         return value;
      }

      public void setValue(int value) {
         this.value = value;
      }
   }
}
