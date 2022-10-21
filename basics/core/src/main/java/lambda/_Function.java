package lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Функциональный интерфейс Function<T,R>
 * представляет функцию перехода от объекта типа T к объекту типа R.
 */

public class _Function {
   public static void main(String[] args) {
      // Function takes 1 arg and produces 1 result
      int increment = incrementByOne(1);
      System.out.println(increment);  // 2

      int increment2 = incrementByOneFun.apply(1);
      System.out.println(increment2); // 2

      int multiply = multiplyFun.apply(increment2);
      System.out.println(multiply);   // 20

      System.out.println(multiplyAndThenFun.apply(4)); // 50

      // BiFunction takes 2 arg and produces 1 result
      System.out.println(incrementByOneBiFun.apply(4, 100)); // 500
   }

   static int incrementByOne(int number) {
      return ++number;
   }

   // incrementByOneFunction = number -> ++number;
   static Function<Integer, Integer> incrementByOneFun = new Function<Integer, Integer>() {
      @Override
      public Integer apply(Integer number) {
         return ++number;
      }
   };

   static Function<Integer, Integer> multiplyFun = number -> number * 10;

   static Function<Integer, Integer> multiplyAndThenFun = incrementByOneFun.andThen(multiplyFun);

   static BiFunction<Integer, Integer, Integer> incrementByOneBiFun = (t, u) -> (t + 1) * u;
}
