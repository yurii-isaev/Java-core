import static org.junit.Assert.assertArrayEquals;

public class Variability {

   // Изменяемость переменных
   public static void main(String[] args) {
      String s = "hello";
      String g = s;

      UnsafeAccess.printAddresses("Address", s); // 0x440b32a40
      UnsafeAccess.printAddresses("Address", g); // 0x440b32a40
      s = "goodbye";
      UnsafeAccess.printAddresses("Address", s); // 0x440b6f300
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
