package functional.monad;

import java.util.function.*;

public class LazyMain {
   public static void main(String[] args) {
      Client client = new Client("Hello world", 15, true);
      Lazy<String> composed = Lazy.from(client)
          .map(Client::getName)
          .map(s -> s.split(" "))
          .map(c -> c[0]);
      System.out.println(composed.get()); // Hello
   }

   public static class Lazy<T> {
      T value;
      Supplier<T> supplier;

      private Lazy(T value) {
         this.value = value;
      }

      private Lazy(Supplier<T> supplier) {
         this.supplier = supplier;
      }

      public static <T> Lazy<T> from(T value) {
         return new Lazy<>(value);
      }

      public T get() {
         // Objects.requireNonNull(value);
         if (value == null) {
            value = supplier.get();
         }
         return value;
      }

      public <U> Lazy<U> map(Function<T, U> mapFunc) {
         return new Lazy<>(() -> mapFunc.apply(get()));
      }

      public <U> Lazy<U> flatMap(Function<T, Lazy<U>> mapFunc) {
         return mapFunc.apply(value);
      }
   }
}
