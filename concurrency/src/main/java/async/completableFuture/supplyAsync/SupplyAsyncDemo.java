package async.completableFuture.supplyAsync;

import async.completableFuture.supplyAsync.data.EmployeeDatabase;
import async.completableFuture.supplyAsync.model.Employee;

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

   // выведет весь список сотрудников в консоль
   public static void main(String[] args) throws ExecutionException, InterruptedException {
      List<Employee> employees = getEmployees();
      employees.forEach(System.out::println);
   }
}
