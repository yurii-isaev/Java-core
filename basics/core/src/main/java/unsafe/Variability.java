package unsafe;

public class Variability {

   // Изменяемость переменных
   public static void main(String[] args) {
      String s = "hello";
      String g = s;

      UnsafeAccess.printAddress(s); // 0x440b32a40
      UnsafeAccess.printAddress(g); // 0x440b32a40
      s = "goodbye";
      UnsafeAccess.printAddress(s); // 0x440b6f300
   }

   // Изменяемость объектов
   class Mutable {
      private int value;

      public Mutable(int value) {
         this.value = value;
      }

      //getter and setter for value
   }

   class Immutable {
      private final int value;

      public Immutable(int value) {
         this.value = value;
      }

      //only getter
   }
}
