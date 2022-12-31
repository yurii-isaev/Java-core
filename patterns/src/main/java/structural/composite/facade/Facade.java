package structural.composite.facade;

// Facade class
class Facade {
   public void operation() {
      Subsystem.SUBSYSTEM_A.operation();
      Subsystem.SUBSYSTEM_B.operation();
      Subsystem.SUBSYSTEM_C.operation();
   }
}
