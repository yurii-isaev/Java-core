package functional.combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface UserValidation extends Function<User, UserValidation.ValidationResult> {

   static UserValidation isEmailValid() {
      return user -> user.getEmail().contains("@")
          ? ValidationResult.SUCCESS
          : ValidationResult.EMAIL_NOT_VALID;
   }

   static UserValidation isPhoneNumberValid() {
      return user -> user.getPhoneNumber().startsWith("+0")
          ? ValidationResult.SUCCESS
          : ValidationResult.PHONE_NUMBER_NOT_VALID;
   }

   static UserValidation isAnAdult() {
      return user -> Period.between(user.getDate(), LocalDate.now()).getYears() >= 16
          ? ValidationResult.SUCCESS
          : ValidationResult.IS_NOT_AN_ADULT;
   }

   default UserValidation and(UserValidation other) {
      return user -> {
         // Выполнение текущей функции
         ValidationResult result = this.apply(user);
         // Выполнение функции аргумента
         return result.equals(ValidationResult.SUCCESS)
             ? other.apply(user)
             : result;
      };
   }

   enum ValidationResult {
      SUCCESS,
      PHONE_NUMBER_NOT_VALID,
      EMAIL_NOT_VALID,
      IS_NOT_AN_ADULT
   }
}
