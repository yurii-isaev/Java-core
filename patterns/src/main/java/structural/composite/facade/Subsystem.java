package structural.composite.facade;

public enum Subsystem {

   SUBSYSTEM_A {
      @Override
      public void operation() {
         System.out.println("SubsystemA: operationA");
      }
   },

   SUBSYSTEM_B {
      @Override
      public void operation() {
         System.out.println("SubsystemB: operationB");
      }
   },

   SUBSYSTEM_C {
      @Override
      public void operation() {
         System.out.println("SubsystemC: operationC");
      }
   };

   public abstract void operation();
}
