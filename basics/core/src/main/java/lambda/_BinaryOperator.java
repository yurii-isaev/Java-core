package lambda;

import java.util.function.BinaryOperator;

/**
 * Функциональный интерфейс BinaryOperator<T>
 * принимает в качестве параметра два объекта типа T,
 * выполняет над ними бинарную операцию и
 * возвращает ее результат также в виде объекта типа T.
 */

public class _BinaryOperator {
   public static void main(String[] args) {
      BinaryOperator<Integer> multiply = (x, y) -> x * y;
      System.out.println(multiply.apply(3, 5));   // 15
      System.out.println(multiply.apply(10, -2)); // -20
   }
}
