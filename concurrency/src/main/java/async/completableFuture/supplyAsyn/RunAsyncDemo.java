package async.completableFuture.supplyAsyn;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;
import java.util.concurrent.*;

public class RunAsyncDemo {

   public static final String FILE_SRC = "/Users/Shved/Documents/Projects/Java-core" +
       "/concurrency/src/main/java/async/future/employees.json";

   public static Void saveEmployees(File jsonFile) throws ExecutionException, InterruptedException {
      ObjectMapper mapper = new ObjectMapper();

      // runAsync - это метод, который позволяет выполнить задачу асинхронно без возвращаемого значения
      CompletableFuture<Void> task = CompletableFuture.runAsync(() -> {
         try {
            List<Employee> employees = mapper
                .readValue(jsonFile, new TypeReference<List<Employee>>() {});
            // write logic save list of employee to database
            // repository.saveAll(employees);
            System.out.println("Thread : " + Thread.currentThread().getName());
            System.out.println(employees.size());
         } catch (IOException e) {
            e.printStackTrace();
         }
      });

      return task.get();
   }

   public static Void saveEmployeesWithPoll(File jsonFile) throws ExecutionException, InterruptedException {
      ObjectMapper mapper = new ObjectMapper();
      Executor executor = Executors.newFixedThreadPool(5);

      CompletableFuture<Void> task = CompletableFuture.runAsync(() -> {
         try {
            List<Employee> employees = mapper
                .readValue(jsonFile, new TypeReference<List<Employee>>() {});
            // write logic save list of employee to database
            // repository.saveAll(employees);
            System.out.println("Thread : " + Thread.currentThread().getName());
            System.out.println(employees.size());
         } catch (IOException e) {
            e.printStackTrace();
         }
      }, executor);

      return task.get();
   }

   public static void main(String[] args) throws ExecutionException, InterruptedException {
      saveEmployees(new File(FILE_SRC));
      saveEmployeesWithPoll(new File(FILE_SRC));
   }
}
