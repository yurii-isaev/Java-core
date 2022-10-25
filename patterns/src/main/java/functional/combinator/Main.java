package functional.combinator;

import java.time.LocalDate;

import static functional.combinator.UserValidation.*;

/**
 * Шаблон проектирования - комбинатор
 */

public class Main {
   public static void main(String[] args) {
      User user = new User(
          "Test",
          "+0898787879878",
          "test@gmail.com",
          LocalDate.of(2000, 1, 1));

      UserValidation.ValidationResult res = UserValidation
          .isEmailValid()
          .and(isPhoneNumberValid())
          .and(isAnAdult())
          .apply(user); // SUCCESS

      System.out.println(res);
   }
}
