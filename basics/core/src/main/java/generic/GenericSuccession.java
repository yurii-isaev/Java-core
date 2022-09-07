package generic;

public class GenericSuccession {
   public class A{}

   public class B extends A{}

   public class C extends A{}

   public static class Gen<T>{

      static void setA(Gen<? extends A> a) { // принимает класс A и наследников
         System.out.println("setA");
      }

      static void setB(Gen<? super B> b) { // принимает класс B и потомков
         System.out.println("setB");
      }

      public static void main(String[] args) {
         Gen<A> genA = new Gen();
         Gen<B> genB = new Gen();
         Gen<C> genC = new Gen();

         setA(genA);
         setA(genB);
         setA(genC);

         setB(genA);
         setB(genB);
         // setB(genC); -> класс С не потомок класс В
      }
   }
}
