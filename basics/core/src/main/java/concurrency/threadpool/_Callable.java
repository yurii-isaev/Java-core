package concurrency.threadpool;

import java.util.*;
import java.util.concurrent.*;

public class _Callable implements Callable {
   private String word;

   public _Callable(String word) {
      this.word = word;
   }

   @Override
   public Integer call() {
      System.out.println(Thread.currentThread().getName() + " , word length: " + word.length());
      return word.length();
   }

   public static void main(String[] args) throws ExecutionException, InterruptedException {
      Scanner scanner = new Scanner(System.in);
      String[] arr = scanner.nextLine().split(" ");

      ExecutorService pool = Executors.newFixedThreadPool(10); // десят потоков в пуле
      Set<Future<Integer>> set = new HashSet<>(); // набор результатов выполнения потоков

      Arrays.stream(arr).forEach(s -> {
         Callable<Integer> callable = new _Callable(s); // создаем объект класса и передаем слово
         Future<Integer> future = pool.submit(callable); // передаем готовый объект в пулл фьюч
         set.add(future); // записываем пул фьюч в набор уникальных значений
      });

      int sum = 0;
      for (Future<Integer> future : set) {
         sum += future.get(); // подсчитываем количество длин слов в наборе уникальных значений
      }
      System.out.printf("The sum of length is %d", sum);
      pool.shutdown();
   }
}
