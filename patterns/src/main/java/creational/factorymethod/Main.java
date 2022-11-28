package creational.factorymethod;

public class Main {
   public static void main(String[] args) {
      Factory factory = Factory.CAR;
      Transport transport = factory.createTransport();
      transport.start();
   }
}
