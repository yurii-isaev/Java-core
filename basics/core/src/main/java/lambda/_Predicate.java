package lambda;

import java.util.function.Predicate;

/**
 * Predicate — функциональный интерфейс для проверки соблюдения некоторого условия.
 * Если условие соблюдается, возвращает true, иначе — false:
 */

public class _Predicate {
   public static void main(String[] args) {
      System.out.println(isPhoneNumberValid("07000000000")); // true
      System.out.println(isPhoneNumberValid("09542485254")); // false

      System.out.println(isPhoneNumberValidByPredicate.test("07000000000")); // true
      System.out.println(isPhoneNumberValidByPredicate.test("09542485254")); // false

      // Predicate chain
      System.out.printf("Is phone number valid and contains number 3 = %b ", isStartsWith
          .and(isLength)
          .and(isContainsNumber)
          .test("07543485254") // true
      );
   }

   static boolean isPhoneNumberValid(String phoneNumber) {
      return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
   }

   static Predicate<String> isPhoneNumberValidByPredicate = t ->
       t.startsWith("07") && t.length() == 11;

   // Separation functionality
   static Predicate<String> isStartsWith = t -> t.startsWith("07");
   static Predicate<String> isLength = t -> t.length() == 11;
   static Predicate<String> isContainsNumber = t -> t.contains("3");
}
