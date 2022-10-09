package unsafe;

public class Mutability {

   // Изменяемость переменных
   public static void main(String[] args) {
      // String
      String hello = "hello";
      String hel = hello;

      UnsafeAccess.printAddress(hello); // 0x440b32a40
      UnsafeAccess.printAddress(hel);   // 0x440b32a40
      speakHello(hello);                        // вызов метода с передачей копии ссылки
      hello = "hello";
      UnsafeAccess.printAddress(hello); // 0x440b32a40

      // StringBuilder
      StringBuilder name = new StringBuilder("hello");
      speak(name);
      name.insert(0,"goodbye");
      UnsafeAccess.printAddress(name); // 0x440b74140
      System.out.println(name); // goodbyehellotest
   }

   // метод принимает копию ссылки и работает с ней, оригинал hello остаенется неизменным
   private static void speakHello(String hello) {
      UnsafeAccess.printAddress(hello); // 0x440b32a40
      hello = "test";
      UnsafeAccess.printAddress(hello); // 0x44104a240
      System.out.println(hello);                // test
   }

   private static void speak(StringBuilder name) {
      name.append("test");
      System.out.println("\n");
      UnsafeAccess.printAddress(name); // 0x440b74140
      System.out.println(name); // hellotest
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
