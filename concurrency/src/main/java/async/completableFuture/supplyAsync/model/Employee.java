package async.completableFuture.supplyAsync.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
   private String employeeId;
   private String firstName;
   private String lastName;
   private String email;
   private String gender;
   private String newJoiner;
   private String learningPending;
   private int salary;
   private int rating;
}
