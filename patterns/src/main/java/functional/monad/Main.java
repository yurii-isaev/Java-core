package functional.monad;

import java.util.function.Function;

/**
 * Монады - это контейнеры или структуры, которые инкапсулируют значения и вычисления.
 * Этот шаблон проектирования состоит из двух частей:
 * 1. Монада - это контейнер значений.
 * Монада представляет собой обертку над значением,
 * которая позволяет преобразовывать и комбинировать значения с помощью функций.
 * Она может использоваться для управления побочными эффектами и обработки ошибок.
 * 2. Монада - реализует "инверсию управления" для внутренне содержащихся значений.
 * Для достижения этого монада предоставляет методы для приема функций.
 * Эти функции принимают значения того же типа, что и те, которые хранятся в монаде,
 * и возвращают преобразованное значение.
 * Преобразованное значение заключено в ту же монаду, что и исходное значение.
 */

public class Main {
   public static void main(String[] args) {
      Client client = new Client("Hello world", 15, true);

      System.out.println(Monad.from(client)
          .map(client1 -> client1.getName())
          .map(s -> s.split(" "))
          .map(c -> c[0])
      ); // monad.Main$Monad@27973e9b
   }

   public static class Monad<T> {
      final T value;

      private Monad(T value) {
         this.value = value;
      }

      public static <T> Monad<T> from(T value) {
         return new Monad<>(value);
      }

      public <U> Monad<U> map(Function<T, U> func) {
         return flatMap(new Function<T, Monad<U>>() {
            @Override
            public Monad<U> apply(T val) {
               return new Monad<>(func.apply(val));
            }
         });
      }

      public <U> Monad<U> flatMap(Function<T, Monad<U>> mapFunc) {
         return mapFunc.apply(value);
      }
   }
}
