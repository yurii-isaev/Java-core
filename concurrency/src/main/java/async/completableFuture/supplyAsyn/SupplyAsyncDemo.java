package async.completableFuture.supplyAsyn;

import async.completableFuture.supplyAsyn.data.EmployeeDatabase;

import java.util.List;
import java.util.concurrent.*;

public class SupplyAsyncDemo {
   public static List<Employee> getEmployees() throws ExecutionException, InterruptedException {
      Executor executor = Executors.newCachedThreadPool();

      // supplyAsync - это метод, который позволяет выполнить задачу асинхронно
      // и получить ее результат в виде CompletableFuture
      CompletableFuture<List<Employee>> list = CompletableFuture.supplyAsync(() -> {
         System.out.println("Executed by : " + Thread.currentThread().getName());
         return EmployeeDatabase.fetchEmployees();
      }, executor);

      return list.get();
   }

   public static void main(String[] args) throws ExecutionException, InterruptedException {
      List<Employee> employees = getEmployees();
      employees.forEach(System.out::println);
   }
}
