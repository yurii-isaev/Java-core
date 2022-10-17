package lambda;

import java.util.function.Consumer;

/**
 * Функция обратного вызова (callback) в Java представляет собой механизм,
 * который позволяет передавать функцию в качестве параметра другому методу.
 * Это позволяет вызывающей функции вызвать переданную функцию в нужный момент времени и
 * передать ей нужные параметры.
 */

public class _Callback {
   public static void main(String[] args) {
      executeCallback();
      consumerCallback("John", null, s -> System.out.println("no lastname provider for " + s));
      runnableCallback("John", null, () -> System.out.println("no lastname provider for"));
   }

   @FunctionalInterface
   public interface Callback {
      void invoke();
   }

   // исполняемый метод
   static void executeCallback() {
      // callback = () -> System.out.println("Callback executed")
      Callback callback = () -> System.out.println("Callback executed");
      // Вызов исполняющего метода с передачей функции в параметр
      executingCallback(callback);
   }

   // исполняющая функция высшего порядка (pure function),
   // так как не зависит от состояния другого объекта
   // и принимает в качестве аргумента другую функцию (TNT)
   static void executingCallback(Callback callback) {
      callback.invoke();
   }

   // не является функция высшего порядка,
   // так как зависит от состояния объекта System
   // но принимает в качестве аргумента другую функцию (TNT)
   static void consumerCallback(String arg1, String arg2, Consumer<String> callback) {
      System.out.println(arg1);
      if (arg2 != null) {
         System.out.println(arg1);
      } else {
         callback.accept(arg1);
      }
   }

   // не является функция высшего порядка,
   // так как зависит от состояния объекта System
   // но принимает в качестве аргумента другую функцию (TNT)
   static void runnableCallback(String arg1, String arg2, Runnable callback) {
      System.out.println(arg1);
      if (arg2 != null) {
         System.out.println(arg1);
      } else {
         callback.run();
      }
   }
}
