package annotation;

public class AnnotationSample {
   public static void main(String[] args) {
      new Executor().execute(new Object());
   }

   public static class Object {

      @Callable
      public void callMethod1() {
         System.out.println("call Method 1");
      }

      @Callable
      public void callMethod2() {
         System.out.println("call Method 2");
      }
   }
}
