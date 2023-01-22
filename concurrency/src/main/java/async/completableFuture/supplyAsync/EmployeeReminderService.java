package async.completableFuture.supplyAsync;

import async.completableFuture.supplyAsync.data.EmployeeDatabase;
import async.completableFuture.supplyAsync.model.Employee;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class EmployeeReminderService {

   public CompletableFuture<Void> sendReminderToEmployee() {
      Executor executor = Executors.newFixedThreadPool(5);

      // CompletableFuture<Void> voidCompletableFuture = CompletableFuture
      return CompletableFuture
          .supplyAsync(() -> {
             System.out.println("fetchEmployee: " + Thread.currentThread().getName());
             return EmployeeDatabase.fetchEmployees();
             }, executor
          )

          .thenApplyAsync((List<Employee> employees) -> {
             System.out.println("filter new joiner employee: " + Thread.currentThread().getName());
             return employees.stream()
                 .filter(employee -> "TRUE".equals(employee.getNewJoiner()))
                 .collect(Collectors.toList());
             }, executor
          )

          .thenApplyAsync((List<Employee> employees) -> {
             System.out.println("filter training not complete employee: " + Thread.currentThread().getName());
             return employees.stream()
                 .filter(employee -> "TRUE".equals(employee.getLearningPending()))
                 .collect(Collectors.toList());
             }, executor
          )

          .thenApplyAsync((List<Employee> employees) -> {
             System.out.println("get emails: " + Thread.currentThread().getName());
             return employees.stream()
                 .map(Employee::getEmail)
                 .collect(Collectors.toList());
             }, executor
          )

          .thenAcceptAsync((List<String> emails) -> {
             System.out.println("send email: " + Thread.currentThread().getName());
             emails.forEach(EmployeeReminderService::sendEmail);
             }, executor
          );
   }

   public static void sendEmail(String email) {
      System.out.println("sending training reminder email to: " + email);
   }

   public static void main(String[] args) throws ExecutionException, InterruptedException {
      EmployeeReminderService service = new EmployeeReminderService();
      service.sendReminderToEmployee().get();

      /*
      fetchEmployee: pool-1-thread-1
      filter new joiner employee : pool-1-thread-2
      filter training not complete employee: pool-1-thread-3
      get emails: pool-1-thread-4
      send email: pool-1-thread-5
       */
   }
}
