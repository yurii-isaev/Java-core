package lambda;

import java.util.function.UnaryOperator;

/**
 * UnaryOperator — функциональный интерфейс, принимает в качестве параметра объект типа T,
 * выполняет над ним некоторые операции и
 * возвращает результат операций в виде объекта того же типа T.
 */

public class _UnaryOperator {
   public static void main(String[] args) {
      UnaryOperator<Integer> squareValue = x -> x * x;
      System.out.println(squareValue.apply(9)); // 81
   }
}
