package lambda;

import java.util.function.Supplier;

/**
 * Supplier (с англ. — поставщик) — функциональный интерфейс,
 * который не принимает никаких аргументов,
 * но возвращает некоторый объект типа T.
 */

public class _Supplier {
   public static void main(String[] args) {
      System.out.println(getUrl());
      System.out.println(getUrlBySupplier.get());
   }

   static String getUrl() {
      return "http://localhost:8080";
   }

   static Supplier<String> getUrlBySupplier = () -> "http://localhost:8080";
}
