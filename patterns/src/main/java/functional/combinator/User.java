package functional.combinator;

import java.time.LocalDate;

public class User {
   public final String name;
   public final String phoneNumber;
   public final String email;
   public final LocalDate dateOfBirth;

   public User(String name, String number, String email, LocalDate date) {
      this.name = name;
      this.phoneNumber = number;
      this.email = email;
      this.dateOfBirth = date;
   }

   public String getName() {
      return name;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public String getEmail() {
      return email;
   }

   public LocalDate getDate() {
      return dateOfBirth;
   }
}
