package behavioral.strategy.cl;

class Lamp implements Strategy{
   @Override
   public void operation() {
      System.out.println("Lamp light on");
   }
}
