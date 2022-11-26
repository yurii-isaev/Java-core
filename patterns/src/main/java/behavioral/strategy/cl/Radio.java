package behavioral.strategy.cl;

class Radio implements Strategy{
   @Override
   public void operation() {
      System.out.println("Radio plays");
   }
}
