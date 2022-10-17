package optional;

import java.util.Optional;

public class _Optional {
   public static void main(String[] args) {
      System.out.println(Optional
          .ofNullable(null)
          .orElseGet(() -> "default value")
      ); // default value

      System.out.println(Optional
          .ofNullable(null)
          .orElseGet(NullPointerException::new)
      ); // 'java.lang.NullPointerException'

      Optional.ofNullable(null).ifPresentOrElse(
          name -> System.out.println("Hello, my name is "+ name),
          () -> System.out.println("no name or was a null pointer")
      ); // no name or was a null pointer

      System.out.println(Optional
          .ofNullable(null)
          .orElseThrow(NullPointerException::new)
      ); // Exception in thread "main" java.lang.NullPointerException -> return method
   }
}
