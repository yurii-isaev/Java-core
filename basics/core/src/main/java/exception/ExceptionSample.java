package exception;

/**
 * При обработке исключений, программа не вылетает из runtime.
 * Throw - позволяет выбросить исключение в любом месте выполнения кода.
 * Throws - обозначает, что метод может выбросить одно или несколько типов исключений.
 */

public class ExceptionSample {
   public static void main(String[] args) throws CustomException {
      //getException();
      //getOutException();
      //getNullPointerException();
      //System.out.println(testFinally()); // 3
      //getInException();
      getCustomException();
   }

   public static void getOutException() {
      int zero = 0;
      int num = 42;
      int res = 0;
      res = num / zero; // ArithmeticException
      System.out.println("Program finished"); // Без обработки программа никогда логично не завершиться
   }

   public static void getException() {
      int zero = 0;
      int num = 42;
      int res = 5;
      try {
         res = num / zero; // ArithmeticException
      } catch (ArithmeticException e) {
         System.out.println("ArithmeticException");
      } catch (NullPointerException e) {
         System.out.println("NullPointerException");
      }
      System.out.println("Program finished");
   }

   public static void getNullPointerException() {
      Integer value = null;
      int zero = 0;
      int num = 42;
      int res = 0;
      try {
         res = value / zero; // NullPointerException
      } catch (ArithmeticException | NullPointerException e) {
         e.printStackTrace();
      }
      System.out.println("Program continues");
   }

   public static int testFinally() {
      try {
         return 1;
      } catch (Exception e) {
         return 2;
      } finally {
         return 3;
      }
   }

   // Сначала выведется содержание блока finally, а потом тип исключения
   public static void getInException() {
      int zero = 0;
      int num = 42;
      int res = 0;
      try {
         res = num / zero;
         System.out.println(res); // 21
      } catch (Exception e) {
         throw new RuntimeException("Exception type: " + e.getClass());
      } finally {
         System.out.println("Program continues"); // Program continues
      }
   }

   // Пример вызова пользовательского исключения
   // Exception in thread "main" exception.CustomException: Value should don't be null
   // Caused by: java.lang.NullPointerException: Cannot invoke "String.trim()" because the return value is null
   public static void getCustomException() throws CustomException {
      try {
         String res = getCustomExceptionValue(null).trim();
         System.out.println(res);
      } catch (Exception e) {
         throw new CustomException("Value should don't be null", e);
      }
   }

   public static String getCustomExceptionValue(String value) {
      return value;
   }
}
