package creational.factorymethod;


public class Audi implements Transport {

   @Override
   public void start() {
      System.out.println("Audi drive");
   }
}
