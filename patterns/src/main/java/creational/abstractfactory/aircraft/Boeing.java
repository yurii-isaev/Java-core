package creational.abstractfactory.aircraft;

public class Boeing implements Aircraft {

   @Override
   public void flight() {
      System.out.println("Boeing flight");
   }
}
