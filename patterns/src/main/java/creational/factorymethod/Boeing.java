package creational.factorymethod;

public class Boeing implements Transport {

   @Override
   public void start() {
      System.out.println("Boeing flight");
   }
}
